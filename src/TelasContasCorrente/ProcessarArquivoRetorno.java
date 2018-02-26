package TelasContasCorrente;

import BeansNS.BeanBanco;
import Beans.BeanBoletosRetorno;
import Beans.BeanBoletos;
import Beans.BeanContaCorrente;
import Beans.BeanOcorrencia;
import Beans.BeanPlanoDeContasMovimentos;
import Beans.BeanPlanoDeContasRelacionamento;
import Beans.BeanRetorno;
import FuncoesInternas.ArquivoRetornoItau;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TransformaValorStringeDouble;
import Parametros.parametrosNS;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
/*
 @author Tiago e Paulo 08/08/2016 as 16:15
 */
public class ProcessarArquivoRetorno extends javax.swing.JFrame {
    //String's
    String sql                  = "";
    String fatal                = "";
    String sqlstate             = "";
    String Mensagem             = "";
    String NomeDaPasta          = "";
    String DataDoDiretorio      = "";
    String AnoDoDiretorio       = "";
        String anodoDiretorio   = "";
    String MesDoDiretorio       = "";
        String mesDoDiretorio   = "";
    String DiaDoDiretorio       = "";
    
    //Vetores
    ArrayList<ArrayList> dadosBanco             = new ArrayList<ArrayList>();
    ArrayList            dadosRetorno           = new ArrayList();
    ArrayList            dadosPadroes           = new ArrayList();
    ArrayList<ArrayList> dadosRelacionamento    = new ArrayList<ArrayList>();
    
    //Bean's
    BeanBanco                           bb          = new BeanBanco();
    BeanBoletos                         bbol        = new BeanBoletos();
    BeanBoletosRetorno                  bbr         = new BeanBoletosRetorno();
    BeanContaCorrente                   bcc         = new BeanContaCorrente();
    BeanOcorrencia                      boco        = new BeanOcorrencia();
    BeanPlanoDeContasRelacionamento     bplarel     = new BeanPlanoDeContasRelacionamento();
    BeanPlanoDeContasMovimentos         bplamov     = new BeanPlanoDeContasMovimentos();
    BeanRetorno                         bretitau    = new BeanRetorno();
    
    //File
    JFileChooser    Seletor     = new JFileChooser();
    File            ArquivoPasta;
    File            PastaAntiga;
    File            PastaNova;
    
    //Especiais
    ArquivoRetornoItau              ArqRetItau  = new ArquivoRetornoItau();
    DefaultTableModel               Table;
    FormataCampo                    fc          = new FormataCampo();
    CapturarDataHora                cdh         = new CapturarDataHora();
    InverterData                    invdata     = new InverterData();
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    
    public ProcessarArquivoRetorno(){
        DataDoDiretorio     = cdh.CapturarData().replace("/", "");
        DiaDoDiretorio      = DataDoDiretorio.substring(0, 2);
        MesDoDiretorio      = DataDoDiretorio.substring(2, 4);
        mesDoDiretorio      = MesDoDiretorio;
        switch(Integer.parseInt(MesDoDiretorio)){
            case  1: MesDoDiretorio = MesDoDiretorio + " - Janeiro"   ; break;
            case  2: MesDoDiretorio = MesDoDiretorio + " - Fevereiro" ; break;
            case  3: MesDoDiretorio = MesDoDiretorio + " - Março"     ; break;
            case  4: MesDoDiretorio = MesDoDiretorio + " - Abril"     ; break;
            case  5: MesDoDiretorio = MesDoDiretorio + " - Maio"      ; break;
            case  6: MesDoDiretorio = MesDoDiretorio + " - Junho"     ; break;
            case  7: MesDoDiretorio = MesDoDiretorio + " - Julho"     ; break;
            case  8: MesDoDiretorio = MesDoDiretorio + " - Agosto"    ; break;
            case  9: MesDoDiretorio = MesDoDiretorio + " - Setembro"  ; break;
            case 10: MesDoDiretorio = MesDoDiretorio + " - Outubro"   ; break;
            case 11: MesDoDiretorio = MesDoDiretorio + " - Novembro"  ; break;
            case 12: MesDoDiretorio = MesDoDiretorio + " - Dezembro"  ; break;
        }
        AnoDoDiretorio      = DataDoDiretorio.substring(4, 8);
            anodoDiretorio  = AnoDoDiretorio.substring(2, 4);
        
        NomeDaPasta         = parametrosNS.PastaSistema + "/Retorno/" + AnoDoDiretorio + "/" + MesDoDiretorio + "/Processados";
        
        initComponents();
        
        Table   = (DefaultTableModel)tabela_retorno.getModel();
        
        PegaRelacionamento();
    }
    
    private void PegaRelacionamento(){
        sql = "select * from tb_planodecontasrelacionamento where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosRelacionamento.clear();
        dadosRelacionamento = parametrosNS.dao.Consulta(sql);
        if(dadosRelacionamento.isEmpty()){
            Mensagem = "Não foi encontrado Relacionamento Contábil!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosRelacionamento();
    }
    
    private void PegaDadosRelacionamento(){
        for(int i = 0; i < dadosRelacionamento.size(); i++){
            if(dadosRelacionamento.get(i).get(0) != null){bplarel.idPlanoDeContasRelacionamento   = Integer.parseInt(String.valueOf(dadosRelacionamento.get(i).get(0)));}
            if(dadosRelacionamento.get(i).get(1) != null){bplarel.idEmpresa                       = Integer.parseInt(String.valueOf(dadosRelacionamento.get(i).get(1)));}
            if(dadosRelacionamento.get(i).get(2) != null){bplarel.codigoGrupo                     = Integer.parseInt(String.valueOf(dadosRelacionamento.get(i).get(2)));}
            if(dadosRelacionamento.get(i).get(3) != null){bplarel.codigoEmpresa                   = Integer.parseInt(String.valueOf(dadosRelacionamento.get(i).get(3)));}
            if(dadosRelacionamento.get(i).get(4) != null){bplarel.codigoPlanoDeContasVendas       =                  String.valueOf(dadosRelacionamento.get(i).get(4));}
            if(dadosRelacionamento.get(i).get(5) != null){bplarel.codigoPlanoDeContasOS           =                  String.valueOf(dadosRelacionamento.get(i).get(5));}
            if(dadosRelacionamento.get(i).get(6) != null){bplarel.codigoPlanoDeContasBoletos      =                  String.valueOf(dadosRelacionamento.get(i).get(6));}
            if(dadosRelacionamento.get(i).get(7) != null){bplarel.codigoPlanoDeContasRecibos      =                  String.valueOf(dadosRelacionamento.get(i).get(7));}
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_nomeDoArquivo = new javax.swing.JTextField();
        bt_buscarArquivo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_retorno = new javax.swing.JTable();
        bt_sair = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        bt_processarArquivo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Processar Arquivo de Retorno");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_nomeDoArquivo.setEditable(false);

        bt_buscarArquivo.setText("Buscar Arquivo");
        bt_buscarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscarArquivoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Especificar diretório do Arquivo de Retorno");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_nomeDoArquivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_buscarArquivo)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_nomeDoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_buscarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_buscarArquivo, txt_nomeDoArquivo});

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Itau.jpg"))); // NOI18N
        jLabel3.setFocusable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Resultado do Processamento");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_retorno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_retorno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Boleto", "Banco", "Agência", "Conta", "Número da Carteira", "Ocorrência", "Número do Documento", "Data de Vencimento", "Valor do Título", "Data de Pagamento", "Valor Pago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_retorno.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela_retorno);
        if (tabela_retorno.getColumnModel().getColumnCount() > 0) {
            tabela_retorno.getColumnModel().getColumn(0).setResizable(false);
            tabela_retorno.getColumnModel().getColumn(1).setResizable(false);
            tabela_retorno.getColumnModel().getColumn(2).setResizable(false);
            tabela_retorno.getColumnModel().getColumn(3).setResizable(false);
            tabela_retorno.getColumnModel().getColumn(4).setResizable(false);
            tabela_retorno.getColumnModel().getColumn(5).setResizable(false);
            tabela_retorno.getColumnModel().getColumn(6).setResizable(false);
            tabela_retorno.getColumnModel().getColumn(7).setResizable(false);
            tabela_retorno.getColumnModel().getColumn(8).setResizable(false);
            tabela_retorno.getColumnModel().getColumn(9).setResizable(false);
            tabela_retorno.getColumnModel().getColumn(10).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jButton4.setText("Imprimir");
        jButton4.setEnabled(false);

        bt_processarArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/1280454766_system-software-update.png"))); // NOI18N
        bt_processarArquivo.setText("Processar Arquivo");
        bt_processarArquivo.setEnabled(false);
        bt_processarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_processarArquivoActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_processarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_processarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_processarArquivo, bt_sair, jButton4});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_buscarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscarArquivoActionPerformed
        Seletor = new JFileChooser("C:/");
        Seletor.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = Seletor.showOpenDialog(null);
        if(i == 1)
            return;
        ArquivoPasta = Seletor.getSelectedFile();
        if(ArquivoPasta.getPath().equals(""))
            return;
        txt_nomeDoArquivo.setText(ArquivoPasta.getPath());
        PegaArquivoRetorno();
    }//GEN-LAST:event_bt_buscarArquivoActionPerformed

    private void bt_processarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processarArquivoActionPerformed
        PegaDadosRetorno();
        if(fatal.equals("S"))return;
        txt_nomeDoArquivo.setText("");
        Table.setNumRows(0);
        bt_processarArquivo.setEnabled(false);
    }//GEN-LAST:event_bt_processarArquivoActionPerformed

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
    private javax.swing.JButton bt_buscarArquivo;
    private javax.swing.JButton bt_processarArquivo;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_retorno;
    private javax.swing.JTextField txt_nomeDoArquivo;
    // End of variables declaration//GEN-END:variables
    
    private void PegaArquivoRetorno(){
        Table.setNumRows(0);
        bt_processarArquivo.setEnabled(false);
        dadosRetorno = ArqRetItau.lerArquivo(ArquivoPasta.getPath());
        if(dadosRetorno.isEmpty())
            return;
        for(int i = 1; i < dadosRetorno.size() - 1; i++){
            bbol.codigoBoleto           =                  ((BeanRetorno)(dadosRetorno.get(i))).DConfirmacaoDoNumeroDoTituloNoBanco;
            bb  .codigoBanco            = String.valueOf  (((BeanRetorno)(dadosRetorno.get(0))).HCodigoDoBanco);
            bcc .numeroDaCarteira       =                  ((BeanRetorno)(dadosRetorno.get(i))).DNumeroDaCarteira;
            bcc .numeroAgencia          =                  ((BeanRetorno)(dadosRetorno.get(i))).DNumeroDaAgencia;
            bcc .numeroContaCorrente    = Integer.parseInt(((BeanRetorno)(dadosRetorno.get(i))).DNumeroDaContaCorrente);
            bcc .digitoVerificador      =                  ((BeanRetorno)(dadosRetorno.get(i))).DDigitoAutoConferencia;
            bbol.ocorrenciaRetorno      = Integer.parseInt(((BeanRetorno)(dadosRetorno.get(i))).DIdentificacaoDaOcorrencia);
            bbol.numeroDocumento        =                  ((BeanRetorno)(dadosRetorno.get(i))).DNumeroDoDocumentoDeCobranca;
            bbol.dataDeVencimento       =                  ((BeanRetorno)(dadosRetorno.get(i))).DDataDeVencimentoDoTitulo;
            bbol.valorDevido            =                  ((BeanRetorno)(dadosRetorno.get(i))).DValorNominalDoTitulo;
            bbol.dataDePagamento        =                  ((BeanRetorno)(dadosRetorno.get(i))).DDataDaOocorrenciaNoBanco;
            bbol.valorPago              =                  ((BeanRetorno)(dadosRetorno.get(i))).DValorLancadoEmContaCorrente;
            
            PegaBanco();
            
            bbol.diaDeVencimento        =         bbol.dataDeVencimento .substring(0, 2);
            bbol.mesDeVencimento        = "/"   + bbol.dataDeVencimento .substring(2, 4);
            bbol.anoDeVencimento        = "/20" + bbol.dataDeVencimento .substring(4, 6);
            bbol.dataDeVencimento       = bbol.diaDeVencimento + bbol.mesDeVencimento + bbol.anoDeVencimento;
            
            bbol.diaDePagamento         =         bbol.dataDePagamento  .substring(0, 2);
            bbol.mesDePagamento         = "/"   + bbol.dataDePagamento  .substring(2, 4);
            bbol.anoDePagamento         = "/20" + bbol.dataDePagamento  .substring(4, 6);
            bbol.dataDePagamento        = bbol.diaDePagamento + bbol.mesDePagamento + bbol.anoDePagamento;
            
            boco.codigoOcorrencia   = bbol.ocorrenciaRetorno;
            switch(boco.codigoOcorrencia){
                case  2: boco.descricaoOcorrencia = "Entrada confirmada";                 break;
                case  3: boco.descricaoOcorrencia = "Entrada rejeitada";                  break;
                case  4: boco.descricaoOcorrencia = "Alteração/Exclusão de dados acatada";break;
                case  5: boco.descricaoOcorrencia = "Alteração de dados - Baixa";         break;
                case  6: boco.descricaoOcorrencia = "Liquidado (L)";                      break;
                case  8: boco.descricaoOcorrencia = "Liquidado (L) - Cartório";           break;
                case  9: boco.descricaoOcorrencia = "Baixado";                            break;
                case 14: boco.descricaoOcorrencia = "Vencimento Alterado";                break;
                default: boco.descricaoOcorrencia = "--------------------";
            }
            
            Table.addRow(new Object[] {fc.FormataCampo(String.valueOf(bbol.codigoBoleto), 8, 0), bb.codigoBanco + "-" + bb.nomeBanco, fc.FormataCampo(String.valueOf(bcc.numeroAgencia), 4, 0), fc.FormataCampo(String.valueOf(bcc.numeroContaCorrente), 5, 0) + "-" + bcc.digitoVerificador, bcc.numeroDaCarteira, fc.FormataCampo(String.valueOf(boco.codigoOcorrencia), 2, 0) + "-" + boco.descricaoOcorrencia, bbol.numeroDocumento, bbol.dataDeVencimento, TransStrDou.TransformaValorStringeDouble(String.valueOf(bbol.valorDevido), 0), bbol.dataDePagamento, TransStrDou.TransformaValorStringeDouble(String.valueOf(bbol.valorPago), 0)});
        }
        if(tabela_retorno.getRowCount() > 0)
            bt_processarArquivo.setEnabled(true);
    }
    
    private void PegaBanco(){
        if(bb.codigoBanco.equals(""))
            return;
        sql = "select * from ns_bancos where codigoBanco = '" + bb.codigoBanco + "';";
        dadosBanco.clear();
        dadosBanco = parametrosNS.dao.Consulta(sql);
        if(dadosBanco.isEmpty()){
            Mensagem = "Banco " + bb.codigoBanco + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosBanco();
    }
    
    private void PegaDadosBanco(){
        for(int i = 0; i < dadosBanco.size(); i++){
            bb.idBanco          = Integer.parseInt(  String.valueOf(dadosBanco.get(i).get(0)));
            bb.nomeBanco        =                    String.valueOf(dadosBanco.get(i).get(1));
            bb.codigoBanco      =                    String.valueOf(dadosBanco.get(i).get(2));
        }
    }
    
    private void PegaDadosRetorno(){
        fatal = "N";
        bbr.idEmpresa               = parametrosNS.be.IdEmpresa;
        bbr.codigoGrupo             = parametrosNS.bge.CodigoGrupo;
        bbr.codigoEmpresa           = parametrosNS.be.CodigoEmpresa;
        for(int i = 0; i < tabela_retorno.getRowCount(); i++){
            bbr.codigoBoleto            = Integer.parseInt                        (String.valueOf(tabela_retorno.getValueAt(i, 0)));
            bbr.numeroDocumento         = String.valueOf                          (               tabela_retorno.getValueAt(i, 6));
            bbr.dataProcessamento       = invdata.inverterData                    (cdh.CapturarData(), 2);
            bbr.horaProcessamento       = cdh.CapturaHora();
            bbr.dataDeVencimento        = invdata.inverterData                    (String.valueOf(tabela_retorno.getValueAt(i, 7)), 2);
            bbr.valorDevido             = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_retorno.getValueAt(i, 8)), 1));
            bbr.dataDePagamento         = invdata.inverterData                    (String.valueOf(tabela_retorno.getValueAt(i, 9)), 2);
            bbr.valorPago               = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_retorno.getValueAt(i, 10)), 1));
            bbr.Ocorrencia              = Integer.parseInt                        (String.valueOf(tabela_retorno.getValueAt(i, 5)).substring(0, 2));
            bbr.codigoBanco             = String.valueOf                          (               tabela_retorno.getValueAt(i, 1)).substring(0, 3);
            bbr.numeroDaCarteira        = String.valueOf                          (               tabela_retorno.getValueAt(i, 4));
            bbr.numeroAgencia           = Integer.parseInt                        (String.valueOf(tabela_retorno.getValueAt(i, 2)));
            bbr.numeroContaCorrente     = Integer.parseInt                        (String.valueOf(tabela_retorno.getValueAt(i, 3)).substring(0, 5));
            bbr.digitoVerificador       = Integer.parseInt                        (String.valueOf(tabela_retorno.getValueAt(i, 3)).substring(6, 7));
            bbr.Observacoes             = "";
            
            if(bbr.Ocorrencia != 6)continue;
            
            sql =   "insert into tb_boletos_retorno (idEmpresa, codigoGrupo, codigoEmpresa, codigoBoleto, numeroDocumento, dataProcessamento, horaProcessamento, dataDeVencimento, valorDevido, dataDePagamento, valorPago, Ocorrencia, codigoBanco, numeroDaCarteira, numeroAgencia, numeroContaCorrente, digitoVerificador, Observacoes) \n" +
                    "values (" + bbr.idEmpresa + ", " + bbr.codigoGrupo + ", " + bbr.codigoEmpresa + ", " + bbr.codigoBoleto + ", '" + bbr.numeroDocumento + "', '" + bbr.dataProcessamento + "', '" + bbr.horaProcessamento + "', '" + bbr.dataDeVencimento + "', " + bbr.valorDevido + ", '" + bbr.dataDePagamento + "', " + bbr.valorPago + ", " + bbr.Ocorrencia + ", '" + bbr.codigoBanco + "', '" + bbr.numeroDaCarteira + "', " + bbr.numeroAgencia + ", " + bbr.numeroContaCorrente + ", " + bbr.digitoVerificador + ", '" + bbr.Observacoes + "');";
            sqlstate = parametrosNS.dao.incluirRegistro(sql);
            if(!sqlstate.equals("00000")){
                Mensagem = "Erro ao Incluir Registro " + bbr.codigoBoleto + "!";
                new MostraMensagem(Mensagem);
                fatal = "S";
                return;
            }
        }
        if(fatal.equals("S"))return;
        AtualizaBoletos();
    }
    
    private void AtualizaBoletos(){
        fatal = "N";
        bbol.idEmpresa          = parametrosNS.be.IdEmpresa;
        bbol.codigoGrupo        = parametrosNS.bge.CodigoGrupo;
        bbol.codigoEmpresa      = parametrosNS.be.CodigoEmpresa;
        for(int i = 0; i < tabela_retorno.getRowCount(); i++){
            bbol.codigoBoleto           = Integer.parseInt                      (String.valueOf(tabela_retorno.getValueAt(i, 0)));
            bbol.dataDePagamento        = invdata.inverterData                  (String.valueOf(tabela_retorno.getValueAt(i, 9)), 2);
            bbol.valorPago              = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_retorno.getValueAt(i, 10)), 1));
            bbol.ocorrenciaRetorno      = Integer.parseInt                      (String.valueOf(tabela_retorno.getValueAt(i, 5)).substring(0, 2));
            bbol.statusBoleto           = 2;
            
            sql = "update tb_boletos set ocorrenciaRetorno = "  + bbol.ocorrenciaRetorno    + ", "
                                      + "statusBoleto = "       + bbol.statusBoleto         + " "
                                      + "where codigoGrupo = "  + bbol.codigoGrupo          + " and " 
                                      + "codigoEmpresa = "      + bbol.codigoEmpresa        + " and "
                                      + "codigoBoleto = "       + bbol.codigoBoleto         + ";";
            if(bbol.ocorrenciaRetorno == 6 || bbol.ocorrenciaRetorno == 8){
                sql = "update tb_boletos set dataDePagamento = '"       + bbol.dataDePagamento      + "', "
                                          + "valorPago = "              + bbol.valorPago            + ", "
                                          + "ocorrenciaRetorno = "      + bbol.ocorrenciaRetorno    + ","
                                          + "statusBoleto = "           + bbol.statusBoleto         + " "
                                          + "where codigoGrupo = "  + bbol.codigoGrupo          + " and " 
                                          + "codigoEmpresa = "      + bbol.codigoEmpresa        + " and "
                                          + "codigoBoleto = "       + bbol.codigoBoleto         + ";";
            }
            sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
            if(!sqlstate.equals("00000")){
                Mensagem = "Erro ao atualizar Boleto n°" + bbol.codigoBoleto + "!";
                new MostraMensagem(Mensagem);
                fatal = "S";
                return;
            }
            
            if(bbol.ocorrenciaRetorno == 6 || bbol.ocorrenciaRetorno == 8)
                IncluirMovimentoContabil();
        }
        if(fatal.equals("S"))return;
        MoveArquivoParaPasta();
    }
    
    private void IncluirMovimentoContabil(){
        if(bplarel.codigoPlanoDeContasVendas.equals("")){
            return;
        }
        bplamov.idEmpresa           = parametrosNS.be.IdEmpresa;
        bplamov.codigoGrupo         = parametrosNS.bge.CodigoGrupo;
        bplamov.codigoEmpresa       = parametrosNS.be.CodigoEmpresa;
        bplamov.codigoPlanoDeContas = bplarel.codigoPlanoDeContasBoletos;
        bplamov.dataPlanoDeContas   = invdata.inverterData(cdh.CapturarData(), 2);
        bplamov.saldo               = bbol.valorPago;
        sql = "insert into tb_planodecontasmovimentos (idEmpresa, codigoGrupo, codigoEmpresa, codigoPlanoDeContas, dataPlanoDeContas, saldo) "
            + "values (" + bplamov.idEmpresa + ", " + bplamov.codigoGrupo + ", " + bplamov.codigoEmpresa + ", " + bplamov.codigoPlanoDeContas + ", '" + bplamov.dataPlanoDeContas + "', " + bplamov.saldo + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            Mensagem = "Erro ao incluir Venda no registro contábil!";
            new MostraMensagem(Mensagem);
//            return;
        }
    }
    
    private void MoveArquivoParaPasta(){
        String Banco    = "";
        if(bb.codigoBanco.equals("341"))Banco = "Itau";
        if(bb.codigoBanco.equals("237"))Banco = "Bradesco";
        fatal = "N";
        try{
            if(!new File(parametrosNS.PastaSistema + "/Retorno").exists()){
                new File(parametrosNS.PastaSistema + "/Retorno").mkdir();
            }
            if(!new File(parametrosNS.PastaSistema + "/Retorno/" + Banco).exists()){
                new File(parametrosNS.PastaSistema + "/Retorno/" + Banco).mkdir();
            }
            if(!new File(parametrosNS.PastaSistema + "/Retorno/" + Banco + "/" + AnoDoDiretorio).exists()){
                new File(parametrosNS.PastaSistema + "/Retorno/" + Banco + "/" + AnoDoDiretorio).mkdir();
            }
            if(!new File(parametrosNS.PastaSistema + "/Retorno/" + Banco + "/" + AnoDoDiretorio + "/" + MesDoDiretorio).exists()){
                new File(parametrosNS.PastaSistema + "/Retorno/" + Banco + "/" + AnoDoDiretorio + "/" + MesDoDiretorio).mkdir();
            }
            if(!new File(parametrosNS.PastaSistema + "/Retorno/" + Banco + "/" + AnoDoDiretorio + "/" + MesDoDiretorio + "/Processados").exists()){
                new File(parametrosNS.PastaSistema + "/Retorno/" + Banco + "/" + AnoDoDiretorio + "/" + MesDoDiretorio + "/Processados").mkdir();
            }
            PastaAntiga = new File(txt_nomeDoArquivo.getText());
            PastaNova   = new File(NomeDaPasta);
            
            PastaAntiga.renameTo(new File(PastaNova, PastaAntiga.getName()));
        }catch(Exception erro){
            Mensagem = "Erro ao mover arquivo de Retorno: " + erro.getMessage();
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        Mensagem = "Arquivo Processado com Sucesso!";
        new MostraMensagem(Mensagem);
    }
    
}
