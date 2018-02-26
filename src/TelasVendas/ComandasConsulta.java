package TelasVendas;

import Beans.BeanComandas;
import Beans.BeanComandasItens;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TransformaValorStringeDouble;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/*
 @author Tiago e Paulo 19/09/2016 at 15:45
 */
public class ComandasConsulta extends javax.swing.JFrame {
    //String's
    String sql                                  = "";
    String Tipo                                 = "";
    String Mensagem                             = "";
    String somostra                             = "";
    String retorno                              = "";
    String statusComanda                        = "";
    
    //int's
    int    Linha                    = 0;
    int    TotalComandasCadastradas = 0;
    int    TotalComandasLivres      = 0;
    int    TotalComandasOcupadas    = 0;
    int    TotalComandasInativas    = 0;
    int    QtdDeItens               = 0;
    
    //double's
    double ValorTotalDasComandas    = 0;
    double TotalDaComanda           = 0;
    
    //Vetores
    ArrayList            parametros         = new ArrayList();
    ArrayList            dadosPadroes       = new ArrayList();
    ArrayList<ArrayList> dadosComandas      = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosComandasItens = new ArrayList<ArrayList>();
    
    //Bean's
    BeanComandas                    bcom    = new BeanComandas();
    BeanComandasItens               bcomi   = new BeanComandasItens();
    
    //Especiais
    FormataCampo                    fc          = new FormataCampo();
    DefaultTableModel               TableComandas;
    TransformaValorStringeDouble    TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    ComandasCadastro    ComCad;
    GerenciarComandas   GerCom;
    
    public ComandasConsulta(ArrayList DadosPadroes){
        dadosPadroes                            = DadosPadroes;
        
        somostra                                = (String)  dadosPadroes.get(0);
        Tipo                                    = (String)  dadosPadroes.get(1);
        
        initComponents();
    }
    
    private void PegaComandas(){
        sql = "select * from tb_comandas where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosComandas.clear();
        dadosComandas = parametrosNS.dao.Consulta(sql);
        if(dadosComandas.isEmpty()){
            Mensagem = "Não existem Comandas Cadastradas!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosComandas();
    }
    
    private void PegaDadosComandas(){
        TableComandas.setNumRows(0);
        TotalComandasCadastradas    = 0;
        TotalComandasLivres         = 0;
        TotalComandasOcupadas       = 0;
        TotalComandasInativas       = 0;
        ValorTotalDasComandas       = 0;
        for(int i = 0; i < dadosComandas.size(); i++){
            bcom = new BeanComandas();
            if(dadosComandas.get(i).get(0) != null){bcom.idComanda              = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(0)));}
            if(dadosComandas.get(i).get(1) != null){bcom.idEmpresa              = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(1)));}
            if(dadosComandas.get(i).get(2) != null){bcom.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(2)));}
            if(dadosComandas.get(i).get(3) != null){bcom.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(3)));}
            if(dadosComandas.get(i).get(4) != null){bcom.codigoComanda          = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(4)));}
            if(dadosComandas.get(i).get(5) != null){bcom.codigoBarrasComanda    =                    String.valueOf(dadosComandas.get(i).get(5));}
            if(dadosComandas.get(i).get(6) != null){bcom.statusComanda          = Integer.parseInt(  String.valueOf(dadosComandas.get(i).get(6)));}
            
            TotalComandasCadastradas++;
            switch(bcom.statusComanda){
                case 0: statusComanda = "Livre";    TotalComandasLivres++;  break;
                case 1: statusComanda = "Ocupada";  TotalComandasOcupadas++;break;
                case 2: statusComanda = "Inativa";  TotalComandasInativas++;break;
            }
            
            bcomi.idEmpresa         = bcom.idEmpresa;
            bcomi.codigoGrupo       = bcom.codigoGrupo;
            bcomi.codigoEmpresa     = bcom.codigoEmpresa;
            bcomi.codigoComanda     = bcom.codigoComanda;
            PegaComandasItens();
            
            TableComandas.addRow(new Object[] {fc.FormataCampo(String.valueOf(bcom.codigoComanda), 3, 0), bcom.codigoBarrasComanda, statusComanda, QtdDeItens, TransStrDou.TransformaValorStringeDouble(String.valueOf(TotalDaComanda), 0)});
        }
        txt_totalComandasCadastradas.setText(String.valueOf(TotalComandasCadastradas));
        txt_totalComandasLivres     .setText(String.valueOf(TotalComandasLivres));
        txt_totalComandasOcupadas   .setText(String.valueOf(TotalComandasOcupadas));
        txt_totalComandasInativas   .setText(String.valueOf(TotalComandasInativas));
        txt_total                   .setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalDasComandas), 0));
    }
    
    private void PegaComandasItens(){
        sql = "select * from tb_comandas_itens where idEmpresa = " + bcomi.idEmpresa + " and codigoComanda = " + bcomi.codigoComanda + ";";
        dadosComandasItens.clear();
        dadosComandasItens = parametrosNS.dao.Consulta(sql);
        PegaDadosComandasItens();
    }
    
    private void PegaDadosComandasItens(){
        QtdDeItens                  = 0;
        TotalDaComanda              = 0;
        for(int i = 0; i < dadosComandasItens.size(); i++){
            if(dadosComandasItens.get(i).get(0)  != null){bcomi.idComandaItem         = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(0)));}
            if(dadosComandasItens.get(i).get(1)  != null){bcomi.idEmpresa             = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(1)));}
            if(dadosComandasItens.get(i).get(2)  != null){bcomi.codigoGrupo           = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(2)));}
            if(dadosComandasItens.get(i).get(3)  != null){bcomi.codigoEmpresa         = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(3)));}
            if(dadosComandasItens.get(i).get(4)  != null){bcomi.codigoComanda         = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(4)));}
            if(dadosComandasItens.get(i).get(5)  != null){bcomi.codigoComandaItem     = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(5)));}
            if(dadosComandasItens.get(i).get(6)  != null){bcomi.codigoProduto         = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(6)));}
            if(dadosComandasItens.get(i).get(7)  != null){bcomi.codigoUsuario         = Integer.parseInt(  String.valueOf(dadosComandasItens.get(i).get(7)));}
            if(dadosComandasItens.get(i).get(8)  != null){bcomi.valorUnitario         = Double.parseDouble(String.valueOf(dadosComandasItens.get(i).get(8)));}
            if(dadosComandasItens.get(i).get(9)  != null){bcomi.quantidade            = Double.parseDouble(String.valueOf(dadosComandasItens.get(i).get(9)));}
            if(dadosComandasItens.get(i).get(10) != null){bcomi.valorTotal            = Double.parseDouble(String.valueOf(dadosComandasItens.get(i).get(10)));}
            
            QtdDeItens++;
            
            TotalDaComanda         += bcomi.valorTotal;
        }
        ValorTotalDasComandas  += TotalDaComanda;
    }
    
    private void PegaValorTabela(){
        Linha = tabela_comandas.getSelectedRow();
        if(Linha < 0){
            Mensagem = "Comanda não selecionada!";
            new MostraMensagem(Mensagem);
            return;
        }
        if(!Tipo.equalsIgnoreCase("CDB")){
            retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_comandas.getValueAt(Linha, 0))));
        }else{
            retorno = String.valueOf(tabela_comandas.getValueAt(Linha, 1));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhesItem = new javax.swing.JMenuItem();
        bt_informacoesComanda = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_comandas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_totalComandasCadastradas = new javax.swing.JTextField();
        txt_totalComandasLivres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_totalComandasOcupadas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_totalComandasInativas = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

        bt_detalhesItem.setText("Detalhes");
        bt_detalhesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesItemActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhesItem);

        bt_informacoesComanda.setText("Informações da Comanda");
        bt_informacoesComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_informacoesComandaActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_informacoesComanda);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Comandas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta de Comandas");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_comandas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_comandas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo da Comanda", "Código de Barras", "Status Comanda", "Qtd de Itens", "Valor total"
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
        tabela_comandas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_comandas.getTableHeader().setResizingAllowed(false);
        tabela_comandas.getTableHeader().setReorderingAllowed(false);
        tabela_comandas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_comandasMouseClicked(evt);
            }
        });
        tabela_comandas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabela_comandasKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_comandas);
        if (tabela_comandas.getColumnModel().getColumnCount() > 0) {
            tabela_comandas.getColumnModel().getColumn(0).setResizable(false);
            tabela_comandas.getColumnModel().getColumn(0).setPreferredWidth(120);
            tabela_comandas.getColumnModel().getColumn(1).setResizable(false);
            tabela_comandas.getColumnModel().getColumn(1).setPreferredWidth(250);
            tabela_comandas.getColumnModel().getColumn(2).setResizable(false);
            tabela_comandas.getColumnModel().getColumn(2).setPreferredWidth(125);
            tabela_comandas.getColumnModel().getColumn(3).setResizable(false);
            tabela_comandas.getColumnModel().getColumn(3).setPreferredWidth(125);
            tabela_comandas.getColumnModel().getColumn(4).setResizable(false);
            tabela_comandas.getColumnModel().getColumn(4).setPreferredWidth(125);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Resumo das Comandas");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Total de Comandas Cadastradas: ");

        txt_totalComandasCadastradas.setEditable(false);
        txt_totalComandasCadastradas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_totalComandasLivres.setEditable(false);
        txt_totalComandasLivres.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Total de Comandas Livres: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Total de Comandas Ocupadas: ");

        txt_totalComandasOcupadas.setEditable(false);
        txt_totalComandasOcupadas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Total de Comandas Inativas: ");

        txt_totalComandasInativas.setEditable(false);
        txt_totalComandasInativas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_totalComandasLivres, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(txt_totalComandasCadastradas)
                    .addComponent(txt_totalComandasOcupadas)
                    .addComponent(txt_totalComandasInativas))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, jLabel6});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_totalComandasCadastradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_totalComandasLivres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_totalComandasOcupadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_totalComandasInativas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, jLabel6, txt_totalComandasCadastradas, txt_totalComandasInativas, txt_totalComandasLivres, txt_totalComandasOcupadas});

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Valor total das Comandas");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_total.setEditable(false);
        txt_total.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        txt_total.setForeground(new java.awt.Color(51, 51, 51));
        txt_total.setText("R$ 0,00");
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_total)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_total)
                .addContainerGap())
        );

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
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
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(bt_sair))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_comandasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_comandasMouseClicked
        PegaValorTabela();
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(somostra.equals("N")){
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
        if(evt.getClickCount() >= 2)
            dispose();
    }//GEN-LAST:event_tabela_comandasMouseClicked

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        
    }//GEN-LAST:event_txt_totalActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        retorno = "";
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(ComCad != null)if(ComCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_comandas.getValueAt(Linha, 0))));
        parametros.clear();
        parametros.add("S");
        parametros.add(Integer.parseInt(retorno));
        ComCad = new ComandasCadastro(parametros);
        ComCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void bt_informacoesComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_informacoesComandaActionPerformed
        if(GerCom != null)if(GerCom.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        retorno = String.valueOf(tabela_comandas.getValueAt(Linha, 1));
        parametros.clear();
        parametros.add("S");
        parametros.add(retorno);
        GerCom = new GerenciarComandas(parametros);
        GerCom.setVisible(true);
    }//GEN-LAST:event_bt_informacoesComandaActionPerformed

    private void tabela_comandasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabela_comandasKeyPressed
       PegaValorTabela();
       dispose();
    }//GEN-LAST:event_tabela_comandasKeyPressed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TableComandas   = (DefaultTableModel)tabela_comandas.getModel();
        PegaComandas();
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_detalhesItem;
    private javax.swing.JMenuItem bt_informacoesComanda;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabela_comandas;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_totalComandasCadastradas;
    private javax.swing.JTextField txt_totalComandasInativas;
    private javax.swing.JTextField txt_totalComandasLivres;
    private javax.swing.JTextField txt_totalComandasOcupadas;
    // End of variables declaration//GEN-END:variables
    
    public String getRetornoComanda(){
        return retorno;
    }
    
}
