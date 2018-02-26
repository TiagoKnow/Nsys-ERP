package TelasFaturamento;

import BeansNS.BeanEmpresas;
import Beans.*;
import FuncoesInternas.*;
import Telas.UsuariosConsulta;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.table.*;
/*
 @author Tiago e Paulo 10/08/2016 as 16:32
 */
public class ContratosConsulta extends javax.swing.JFrame {
    //String's
    String sql                                  = "";
    String retorno                              = "";
    String Campo                                = "";
    String retorno1                             = "";
    String somostra                             = "";
    String sqlstate                             = "";
    String Mensagem                             = "";
    String preenchimento                        = "";
    String StatusContrato                       = "";
    
    //int's
    int    Linha                                = 0;
    int    QtdRegistros                         = 0;
    int    abriuCliente                         = 0;
    int    abriuUsuario                         = 0;
    int    abriuManutencao                      = 0;
    int    dataContrato                         = 0;
    int    dataCadastro                         = 0;
    int    dataVencimento                       = 0;
    
    //Vetores
    ArrayList            parametros             = new ArrayList();
    ArrayList<ArrayList> dadosCliente           = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosContratos         = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosEmpresas          = new ArrayList<ArrayList>();
    ArrayList            dadosPadroes           = new ArrayList();
    ArrayList<ArrayList> dadosUsuario           = new ArrayList<ArrayList>();
    
    //Bean's
    BeanClientes                        bc      = new BeanClientes();
    BeanContratos                       bcon    = new BeanContratos();
    BeanEmpresas                        be      = new BeanEmpresas();
    BeanIntervalos                      binter  = new BeanIntervalos();
    BeanUsuarios                        bu      = new BeanUsuarios();
    
    //Especiais
    FormataCampo                        fc      = new FormataCampo();
    DefaultTableModel                   TableContratos;
    TestarData                          Test    = new TestarData();
    InverterData                        invdata = new InverterData();
    
    //Telas
    ClientesConsulta                    CliCon;
    UsuariosConsulta                    UsuCon;
    ManutencoesConsulta                 ManCon;
    ContratosCadastro                   ConCad;
    
    public ContratosConsulta(ArrayList DadosPadroes){
        dadosPadroes                            = DadosPadroes;
        
        somostra                                = (String)  dadosPadroes.get(0);
        bc.codigoCliente                        = (int)     dadosPadroes.get(1);
        
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_codigoContratoInicial   .setText(fc.FormataCampo("", 9, 0));
        txt_codigoContratoFinal     .setText("999999999");
        txt_codigoClienteInicial    .setText(fc.FormataCampo("", 5, 0));
        txt_codigoClienteFinal      .setText("99999");
        txt_dataContratoInicial     .setText(fc.FormataCampo("",10, 2));
        txt_dataContratoFinal       .setText("99999999");
        txt_codigoUsuarioInicial    .setText(fc.FormataCampo("", 3, 0));
        txt_codigoUsuarioFinal      .setText("999");
        txt_dataCadastroInicial     .setText(fc.FormataCampo("",10, 2));
        txt_dataCadastroFinal       .setText("99999999");
        txt_dataVencimentoInicial   .setText(fc.FormataCampo("",10, 2));
        txt_dataVencimentoFinal     .setText("99999999");
        txt_descricaoContrato       .setText("");
    }
    
    private void PegaValores(){
        binter.codigoContratoInicial        = Integer.parseInt(txt_codigoContratoInicial.getText());
        binter.codigoContratoFinal          = Integer.parseInt(txt_codigoContratoFinal.getText());
        if(binter.codigoContratoInicial > binter.codigoContratoFinal){
            Mensagem = "Contrato Inicial não pode ser maior do que o Contrato Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.clienteInicial               = Integer.parseInt(txt_codigoClienteInicial.getText());
        binter.clienteFinal                 = Integer.parseInt(txt_codigoClienteFinal.getText());
        if(binter.clienteInicial > binter.clienteFinal){
            Mensagem = "Cliente Inicial não pode ser maior do que o Cliente Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.dataContratoInicial          = Test.Testa(txt_dataContratoInicial.getText());
        binter.dataContratoFinal            = Test.Testa(txt_dataContratoFinal.getText());
        if(binter.dataContratoInicial > binter.dataContratoFinal){
            Mensagem = "Data do Contrato Inicial não pode ser maior do que a Data do Contrato Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.usuarioInicial               = Integer.parseInt(txt_codigoUsuarioInicial.getText());
        binter.usuarioFinal                 = Integer.parseInt(txt_codigoUsuarioFinal.getText());
        if(binter.usuarioInicial > binter.usuarioFinal){
            Mensagem = "Usuário Inicial não pode ser maior do que o Usuário Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.dataCadastroInicial          = Test.Testa(txt_dataCadastroInicial.getText());
        binter.dataCadastroFinal            = Test.Testa(txt_dataCadastroFinal.getText());
        if(binter.dataCadastroInicial > binter.dataCadastroFinal){
            Mensagem = "Data de Cadastro Inicial não pode ser maior do que a Data de Cadastro Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.dataVencimentoInicial        = Test.Testa(txt_dataVencimentoInicial.getText());
        binter.dataVencimentoFinal          = Test.Testa(txt_dataVencimentoFinal.getText());
        if(binter.dataVencimentoInicial > binter.dataVencimentoFinal){
            Mensagem = "Data de Vencimento Inicial não pode ser maior do que a Data de Vencimento Final!";
            new MostraMensagem(Mensagem);
            return;
        }
        
        binter.descricaoContrato            = txt_descricaoContrato.getText();
        if(!binter.descricaoContrato.equals(""))
            preenchimento   = "   descricaoContrato like '%" + binter.descricaoContrato + "%' and \n";
        else
            preenchimento   = "";
        PegaContratos();
    }
    
    private void PegaContratos(){
        sql = "select \n"
              + "   idContrato, \n"
              + "   idEmpresa, \n"
              + "   codigoGrupo, \n"
              + "   codigoEmpresa, \n"
              + "   codigoContrato, \n"
              + "   codigoCliente, \n"
              + "   codigoUsuario, \n"
              + "   valorContrato, \n"
              + "   dataCadastro, \n"
              + "   dataContrato, \n"
              + "   dataVencimento, \n"
              + "   dataReajuste, \n"
              + "   descricaoContrato, \n"
              + "   statusContrato \n"
              + "from tb_contratos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and \n"
              + preenchimento
              + "   codigoCliente between "      + binter.clienteInicial             + " and " + binter.clienteFinal             + " and \n"
              + "   codigoContrato between "     + binter.codigoContratoInicial      + " and " + binter.codigoContratoFinal      + " and \n"
              + "   codigoUsuario between "      + binter.usuarioInicial             + " and " + binter.usuarioFinal             /*+ " and \n"
              + "   dataCadastro between "       + binter.dataCadastroInicial        + " and " + binter.dataCadastroFinal        + " and \n"
              + "   dataContrato between "       + binter.dataContratoInicial        + " and " + binter.dataContratoFinal        + " and \n"
              + "   dataVencimento between "     + binter.dataVencimentoInicial      + " and " + binter.dataVencimentoFinal      */+ ";";
        dadosContratos.clear();
        dadosContratos = parametrosNS.dao.Consulta(sql);
        PreencherTabela();
    }
    
    private void PreencherTabela(){
        tabela_contratos.getColumnModel().getColumn(0).setResizable(false);
        tabela_contratos.getColumnModel().getColumn(1).setPreferredWidth(300);
        tabela_contratos.getColumnModel().getColumn(2).setPreferredWidth(275);
        tabela_contratos.getColumnModel().getColumn(3).setPreferredWidth(125);
        tabela_contratos.getColumnModel().getColumn(4).setResizable(false);
        tabela_contratos.getColumnModel().getColumn(4).setPreferredWidth(150);
        tabela_contratos.getColumnModel().getColumn(5).setResizable(false);
        tabela_contratos.getColumnModel().getColumn(6).setResizable(false);
        tabela_contratos.getColumnModel().getColumn(7).setResizable(false);
        tabela_contratos.getColumnModel().getColumn(7).setPreferredWidth(225);
        tabela_contratos.getColumnModel().getColumn(8).setResizable(false);
        tabela_contratos.getColumnModel().getColumn(8).setPreferredWidth(150);
            
        TableContratos.setNumRows(0);
        QtdRegistros = 0;
        for(int i = 0; i < dadosContratos.size(); i++){
            bcon = new BeanContratos();
            if(dadosContratos.get(i).get(0) != null)
                bcon.idContrato         = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(0)));
            if(dadosContratos.get(i).get(1) != null)
                bcon.idEmpresa          = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(1)));
            if(dadosContratos.get(i).get(2) != null)
                bcon.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(2)));
            if(dadosContratos.get(i).get(3) != null)
                bcon.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(3)));
            if(dadosContratos.get(i).get(4) != null)
                bcon.codigoContrato     = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(4)));
            if(dadosContratos.get(i).get(5) != null)
                bcon.codigoCliente      = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(5)));
            if(dadosContratos.get(i).get(6) != null)
                bcon.codigoUsuario      = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(6)));
            if(dadosContratos.get(i).get(7) != null)
                bcon.valorContrato      = Double.parseDouble(String.valueOf(dadosContratos.get(i).get(7)));
                bcon.dataCadastro       =                    String.valueOf(dadosContratos.get(i).get(8));
                bcon.dataContrato       =                    String.valueOf(dadosContratos.get(i).get(9));
                bcon.dataVencimento     =                    String.valueOf(dadosContratos.get(i).get(10));
                bcon.dataReajuste       =                    String.valueOf(dadosContratos.get(i).get(11));
                bcon.descricaoContrato  =                    String.valueOf(dadosContratos.get(i).get(12));
            if(dadosContratos.get(i).get(13) != null)
                bcon.statusContrato     = Integer.parseInt(  String.valueOf(dadosContratos.get(i).get(13)));
            
            if(bcon.dataCadastro    != null)dataCadastro      = Test.Testa(invdata.inverterData(bcon.dataCadastro  , 1));else dataCadastro    = 0;
            if(bcon.dataContrato    != null)dataContrato      = Test.Testa(invdata.inverterData(bcon.dataContrato  , 1));else dataContrato    = 0;
            if(bcon.dataVencimento  != null)dataVencimento    = Test.Testa(invdata.inverterData(bcon.dataVencimento, 1));else dataVencimento  = 0;
            
            if(dataCadastro         < binter.dataCadastroInicial)   continue;
            if(dataCadastro         > binter.dataCadastroFinal)     continue;
            if(dataContrato         < binter.dataContratoInicial)   continue;
            if(dataContrato         > binter.dataContratoFinal)     continue;
            if(dataVencimento       < binter.dataVencimentoInicial) continue;
            if(dataVencimento       > binter.dataVencimentoFinal)   continue;
            
            bc.codigoCliente        = bcon.codigoCliente;
            PegaCliente();
            
            bu.codigoUsuario        = bcon.codigoUsuario;
            PegaUsuario();
            
            be.idEmpresa            = bcon.idEmpresa;
            be.codigoGrupo          = bcon.codigoGrupo;
            be.codigoEmpresa        = bcon.codigoEmpresa;
            PegaEmpresa();
            
            bcon.dataContrato       = invdata.inverterData(bcon.dataContrato    , 1);
            bcon.dataCadastro       = invdata.inverterData(bcon.dataCadastro    , 1);
            bcon.dataVencimento     = invdata.inverterData(bcon.dataVencimento  , 1);
            
            StatusContrato          = fc.FormataCampo(String.valueOf(bcon.statusContrato), 1, 0);
            
            switch(bcon.statusContrato){
                case 0: StatusContrato += " - Pendente";    break;
                case 1: StatusContrato += " - Cancelado";   break;
                case 2: StatusContrato += " - Pago";        break;
            }
            
            QtdRegistros++;
            
            TableContratos.addRow(new Object [] {fc.FormataCampo(String.valueOf(bcon.codigoContrato), 9, 0), be.NomeEmpresa, fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0) + "-" + bc.nome, fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0) + "-" + bu.usuario, bcon.dataContrato, bcon.dataCadastro, bcon.dataVencimento, bcon.descricaoContrato, StatusContrato});
        }
        txt_quantidadeRegistros.setText(String.valueOf(QtdRegistros));
    }
    
    private void PegaEmpresa(){
        be.NomeEmpresa  = "----------------------------------------";
        sql = "select * from ns_empresas where codigoGrupo = " + be.codigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
        dadosEmpresas.clear();
        dadosEmpresas = parametrosNS.dao.Consulta(sql);
        if(dadosEmpresas.isEmpty())
            return;
        PegaDadosEmpresa();
    }
    
    private void PegaDadosEmpresa(){
        for(int i = 0; i < dadosEmpresas.size(); i++){
            be.CodigoGrupo      = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(1)));
            be.CodigoEmpresa    = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(2)));
            be.NomeEmpresa      =                    String.valueOf(dadosEmpresas.get(i).get(4));
            be.NomeFantasia     =                    String.valueOf(dadosEmpresas.get(i).get(5));
            be.CnpjEmpresa      =                    String.valueOf(dadosEmpresas.get(i).get(6));
        }
        be.NomeEmpresa  = fc.FormataCampo(String.valueOf(be.CodigoEmpresa), 3, 0) + "-" + be.NomeEmpresa;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhesItem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_contratos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_quantidadeRegistros = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_codigoContratoInicial = new javax.swing.JFormattedTextField();
        txt_codigoContratoFinal = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_dataContratoInicial = new javax.swing.JFormattedTextField();
        txt_dataCadastroInicial = new javax.swing.JFormattedTextField();
        txt_dataVencimentoInicial = new javax.swing.JFormattedTextField();
        txt_dataContratoFinal = new javax.swing.JFormattedTextField();
        txt_dataCadastroFinal = new javax.swing.JFormattedTextField();
        txt_dataVencimentoFinal = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_descricaoContrato = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_codigoClienteInicial = new javax.swing.JFormattedTextField();
        txt_codigoClienteFinal = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_codigoUsuarioInicial = new javax.swing.JFormattedTextField();
        txt_codigoUsuarioFinal = new javax.swing.JFormattedTextField();
        bt_pesquisaClienteInicial = new javax.swing.JButton();
        bt_pesquisaClienteFinal = new javax.swing.JButton();
        bt_pesquisaUsuarioInicial = new javax.swing.JButton();
        bt_pesquisaUsuarioFinal = new javax.swing.JButton();
        bt_processa = new javax.swing.JButton();

        bt_detalhesItem.setText("Detalhes");
        bt_detalhesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesItemActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhesItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultas Contratos");
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
        jLabel1.setText("Consulta de Contratos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_contratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° do Contrato", "Nome da Empresa", "Cliente", "Cadastrado Por", "Data do Contrato", "Dada de Cadastro", "Data de Vencimento", "Descricão", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_contratos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_contratos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_contratos.getTableHeader().setReorderingAllowed(false);
        tabela_contratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_contratosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_contratos);
        if (tabela_contratos.getColumnModel().getColumnCount() > 0) {
            tabela_contratos.getColumnModel().getColumn(0).setResizable(false);
            tabela_contratos.getColumnModel().getColumn(1).setResizable(false);
            tabela_contratos.getColumnModel().getColumn(2).setResizable(false);
            tabela_contratos.getColumnModel().getColumn(3).setResizable(false);
            tabela_contratos.getColumnModel().getColumn(4).setResizable(false);
            tabela_contratos.getColumnModel().getColumn(5).setResizable(false);
            tabela_contratos.getColumnModel().getColumn(6).setResizable(false);
            tabela_contratos.getColumnModel().getColumn(7).setResizable(false);
            tabela_contratos.getColumnModel().getColumn(8).setResizable(false);
        }

        jLabel2.setText("Registros");

        txt_quantidadeRegistros.setEditable(false);
        txt_quantidadeRegistros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_quantidadeRegistros.setEnabled(false);

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
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_quantidadeRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_quantidadeRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, txt_quantidadeRegistros});

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Intervalos de Consulta      F11[Geral]");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Código:");

        try {
            txt_codigoContratoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoContratoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoContratoInicial.setText("000000000");
        txt_codigoContratoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoContratoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoContratoInicialFocusLost(evt);
            }
        });
        txt_codigoContratoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoContratoInicialKeyPressed(evt);
            }
        });

        try {
            txt_codigoContratoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoContratoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoContratoFinal.setText("999999999");
        txt_codigoContratoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoContratoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoContratoFinalFocusLost(evt);
            }
        });
        txt_codigoContratoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoContratoFinalKeyPressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Inicial");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Final");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Inicial");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Final");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Data do Contrato:");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Data de Cadastro:");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Data de Vencimento:");

        try {
            txt_dataContratoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataContratoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataContratoInicial.setText("00/00/0000");
        txt_dataContratoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataContratoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataContratoInicialFocusLost(evt);
            }
        });
        txt_dataContratoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataContratoInicialKeyPressed(evt);
            }
        });

        try {
            txt_dataCadastroInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastroInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataCadastroInicial.setText("00/00/0000");
        txt_dataCadastroInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataCadastroInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataCadastroInicialFocusLost(evt);
            }
        });
        txt_dataCadastroInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataCadastroInicialKeyPressed(evt);
            }
        });

        try {
            txt_dataVencimentoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVencimentoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataVencimentoInicial.setText("00/00/0000");
        txt_dataVencimentoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataVencimentoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataVencimentoInicialFocusLost(evt);
            }
        });
        txt_dataVencimentoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataVencimentoInicialKeyPressed(evt);
            }
        });

        try {
            txt_dataContratoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataContratoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataContratoFinal.setText("99/99/9999");
        txt_dataContratoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataContratoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataContratoFinalFocusLost(evt);
            }
        });
        txt_dataContratoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataContratoFinalKeyPressed(evt);
            }
        });

        try {
            txt_dataCadastroFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastroFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataCadastroFinal.setText("99/99/9999");
        txt_dataCadastroFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataCadastroFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataCadastroFinalFocusLost(evt);
            }
        });
        txt_dataCadastroFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataCadastroFinalKeyPressed(evt);
            }
        });

        try {
            txt_dataVencimentoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVencimentoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataVencimentoFinal.setText("99/99/9999");
        txt_dataVencimentoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dataVencimentoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataVencimentoFinalFocusLost(evt);
            }
        });
        txt_dataVencimentoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dataVencimentoFinalKeyPressed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Descrição:");

        txt_descricaoContrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_descricaoContratoKeyPressed(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Cliente:");

        try {
            txt_codigoClienteInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoClienteInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoClienteInicial.setText("00000");
        txt_codigoClienteInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoClienteInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoClienteInicialFocusLost(evt);
            }
        });
        txt_codigoClienteInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoClienteInicialKeyPressed(evt);
            }
        });

        try {
            txt_codigoClienteFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoClienteFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoClienteFinal.setText("99999");
        txt_codigoClienteFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoClienteFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoClienteFinalFocusLost(evt);
            }
        });
        txt_codigoClienteFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoClienteFinalKeyPressed(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Usuario:");

        try {
            txt_codigoUsuarioInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuarioInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoUsuarioInicial.setText("000");
        txt_codigoUsuarioInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoUsuarioInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoUsuarioInicialFocusLost(evt);
            }
        });
        txt_codigoUsuarioInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoUsuarioInicialKeyPressed(evt);
            }
        });

        try {
            txt_codigoUsuarioFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuarioFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoUsuarioFinal.setText("999");
        txt_codigoUsuarioFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoUsuarioFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoUsuarioFinalFocusLost(evt);
            }
        });
        txt_codigoUsuarioFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoUsuarioFinalKeyPressed(evt);
            }
        });

        bt_pesquisaClienteInicial.setText("...");
        bt_pesquisaClienteInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaClienteInicialActionPerformed(evt);
            }
        });

        bt_pesquisaClienteFinal.setText("...");
        bt_pesquisaClienteFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaClienteFinalActionPerformed(evt);
            }
        });

        bt_pesquisaUsuarioInicial.setText("...");
        bt_pesquisaUsuarioInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaUsuarioInicialActionPerformed(evt);
            }
        });

        bt_pesquisaUsuarioFinal.setText("...");
        bt_pesquisaUsuarioFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaUsuarioFinalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_dataVencimentoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(txt_dataCadastroInicial)
                            .addComponent(txt_dataContratoInicial)
                            .addComponent(txt_codigoContratoInicial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_dataVencimentoFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_codigoContratoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_dataCadastroFinal)
                                    .addComponent(txt_dataContratoFinal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_descricaoContrato)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txt_codigoClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bt_pesquisaClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txt_codigoUsuarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bt_pesquisaUsuarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_codigoUsuarioFinal)
                                            .addComponent(txt_codigoClienteFinal)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bt_pesquisaUsuarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bt_pesquisaClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addGap(98, 166, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel4});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel13, jLabel14, jLabel15});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_codigoClienteFinal, txt_codigoClienteInicial, txt_codigoUsuarioFinal, txt_codigoUsuarioInicial});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel5, jLabel6, txt_codigoContratoFinal, txt_codigoContratoInicial, txt_dataCadastroFinal, txt_dataCadastroInicial, txt_dataContratoFinal, txt_dataContratoInicial, txt_dataVencimentoFinal, txt_dataVencimentoInicial});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_codigoContratoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_codigoContratoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_dataContratoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_dataContratoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_dataCadastroInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_dataVencimentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_dataVencimentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addComponent(txt_dataCadastroFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addGap(32, 32, 32)
                            .addComponent(jLabel13))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addGap(26, 26, 26))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(txt_descricaoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_codigoClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bt_pesquisaClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_codigoUsuarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bt_pesquisaUsuarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_codigoClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bt_pesquisaClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_codigoUsuarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt_pesquisaUsuarioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaClienteFinal, bt_pesquisaClienteInicial, bt_pesquisaUsuarioFinal, bt_pesquisaUsuarioInicial, jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel15, jLabel4, jLabel5, jLabel6, jLabel8, jLabel9, txt_codigoClienteFinal, txt_codigoClienteInicial, txt_codigoContratoFinal, txt_codigoContratoInicial, txt_codigoUsuarioFinal, txt_codigoUsuarioInicial, txt_dataCadastroFinal, txt_dataCadastroInicial, txt_dataContratoFinal, txt_dataContratoInicial, txt_dataVencimentoFinal, txt_dataVencimentoInicial, txt_descricaoContrato});

        bt_processa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/1280454766_system-software-update.png"))); // NOI18N
        bt_processa.setText("Processa");
        bt_processa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_processaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(bt_processa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
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
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_processa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_processa, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabela_contratosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_contratosMouseClicked
        Linha       = tabela_contratos.getSelectedRow();
        if(Linha < 0){
            Mensagem = "Item não selecionado!";
            new MostraMensagem(Mensagem);
            return;
        }
        retorno1    = String.valueOf(Integer.parseInt(String.valueOf(tabela_contratos.getValueAt(Linha, 2)).substring(0, 5)));
        retorno     = String.valueOf(Integer.parseInt(String.valueOf(tabela_contratos.getValueAt(Linha, 0))));
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(somostra.equalsIgnoreCase("N")){
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_contratosMouseClicked

    private void bt_detalhesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesItemActionPerformed
        if(ConCad != null)if(ConCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("S");
        parametros.add(Integer.parseInt(retorno1));
        parametros.add(Integer.parseInt(retorno));
        ConCad = new ContratosCadastro(parametros);
        ConCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesItemActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_processaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_processaActionPerformed
        PegaValores();
    }//GEN-LAST:event_bt_processaActionPerformed

    private void txt_codigoContratoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoContratoInicialFocusLost
        txt_codigoContratoInicial.setText(fc.FormataCampo(txt_codigoContratoInicial.getText(), 9, 0));
    }//GEN-LAST:event_txt_codigoContratoInicialFocusLost

    private void txt_codigoContratoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoContratoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoContratoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoContratoInicial.setText(fc.FormataCampo("", 9, 0));
            txt_codigoContratoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoContratoInicialKeyPressed

    private void txt_codigoContratoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoContratoFinalFocusLost
        txt_codigoContratoFinal.setText(fc.FormataCampo(txt_codigoContratoFinal.getText(), 9, 0));
    }//GEN-LAST:event_txt_codigoContratoFinalFocusLost

    private void txt_codigoContratoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoContratoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoClienteInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoContratoFinal.setText("999999999");
            txt_codigoClienteInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoContratoFinalKeyPressed

    private void txt_codigoClienteInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteInicialFocusLost
        txt_codigoClienteInicial.setText(fc.FormataCampo(txt_codigoClienteInicial.getText(), 5, 0));
    }//GEN-LAST:event_txt_codigoClienteInicialFocusLost

    private void txt_codigoClienteInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoClienteInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoClienteFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoClienteInicial.setText(fc.FormataCampo("", 5, 0));
            txt_codigoClienteFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoClienteInicialKeyPressed

    private void txt_codigoClienteFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFinalFocusLost
        txt_codigoClienteFinal.setText(fc.FormataCampo(txt_codigoClienteFinal.getText(), 5, 0));
    }//GEN-LAST:event_txt_codigoClienteFinalFocusLost

    private void txt_codigoClienteFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoClienteFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataContratoInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoClienteFinal.setText("99999");
            txt_dataContratoInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoClienteFinalKeyPressed

    private void txt_dataContratoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataContratoInicialFocusLost
        txt_dataContratoInicial.setText(fc.FormataCampo(txt_dataContratoInicial.getText(),10, 2));
    }//GEN-LAST:event_txt_dataContratoInicialFocusLost

    private void txt_dataContratoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataContratoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataContratoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataContratoInicial.setText(fc.FormataCampo("",10, 2));
            txt_dataContratoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataContratoInicialKeyPressed

    private void txt_dataContratoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataContratoFinalFocusLost
        txt_dataContratoFinal.setText(fc.FormataCampo(txt_dataContratoFinal.getText(),10, 2));
    }//GEN-LAST:event_txt_dataContratoFinalFocusLost

    private void txt_dataContratoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataContratoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoUsuarioInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataContratoFinal.setText("99999999");
            txt_codigoUsuarioInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataContratoFinalKeyPressed

    private void txt_codigoUsuarioInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioInicialFocusLost
        txt_codigoUsuarioInicial.setText(fc.FormataCampo(txt_codigoUsuarioInicial.getText(), 3, 0));
    }//GEN-LAST:event_txt_codigoUsuarioInicialFocusLost

    private void txt_codigoUsuarioInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoUsuarioFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoUsuarioInicial.setText(fc.FormataCampo("", 3, 0));
            txt_codigoUsuarioFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoUsuarioInicialKeyPressed

    private void txt_codigoUsuarioFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioFinalFocusLost
        txt_codigoUsuarioFinal.setText(fc.FormataCampo(txt_codigoUsuarioFinal.getText(), 3, 0));
    }//GEN-LAST:event_txt_codigoUsuarioFinalFocusLost

    private void txt_codigoUsuarioFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataCadastroInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoUsuarioFinal.setText("999");
            txt_dataCadastroInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoUsuarioFinalKeyPressed

    private void txt_dataCadastroInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroInicialFocusLost
        txt_dataCadastroInicial.setText(fc.FormataCampo(txt_dataCadastroInicial.getText(),10, 2));
    }//GEN-LAST:event_txt_dataCadastroInicialFocusLost

    private void txt_dataCadastroInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataCadastroInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataCadastroFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataCadastroInicial.setText(fc.FormataCampo("",10, 2));
            txt_dataCadastroFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataCadastroInicialKeyPressed

    private void txt_dataCadastroFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroFinalFocusLost
        txt_dataCadastroFinal.setText(fc.FormataCampo(txt_dataCadastroFinal.getText(),10, 2));
    }//GEN-LAST:event_txt_dataCadastroFinalFocusLost

    private void txt_dataCadastroFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataCadastroFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_descricaoContrato.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataCadastroFinal.setText("99999999");
            txt_descricaoContrato.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataCadastroFinalKeyPressed

    private void txt_dataVencimentoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVencimentoInicialFocusLost
        txt_dataVencimentoInicial.setText(fc.FormataCampo(txt_dataVencimentoInicial.getText(),10, 2));
    }//GEN-LAST:event_txt_dataVencimentoInicialFocusLost

    private void txt_dataVencimentoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataVencimentoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataVencimentoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataVencimentoInicial.setText(fc.FormataCampo("",10, 2));
            txt_dataVencimentoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataVencimentoInicialKeyPressed

    private void txt_dataVencimentoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVencimentoFinalFocusLost
        txt_dataVencimentoFinal.setText(fc.FormataCampo(txt_dataVencimentoFinal.getText(),10, 2));
    }//GEN-LAST:event_txt_dataVencimentoFinalFocusLost

    private void txt_dataVencimentoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataVencimentoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_processa.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataVencimentoFinal.setText("99999999");
            bt_processa.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataVencimentoFinalKeyPressed

    private void txt_descricaoContratoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoContratoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_processa.grabFocus();
        }
    }//GEN-LAST:event_txt_descricaoContratoKeyPressed

    private void txt_codigoContratoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoContratoInicialFocusGained
        new SelecaoDeCampo(null, txt_codigoContratoInicial);
    }//GEN-LAST:event_txt_codigoContratoInicialFocusGained

    private void txt_codigoContratoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoContratoFinalFocusGained
        new SelecaoDeCampo(null,  txt_codigoContratoFinal);
    }//GEN-LAST:event_txt_codigoContratoFinalFocusGained

    private void txt_codigoClienteInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteInicialFocusGained
        new SelecaoDeCampo(null, txt_codigoClienteInicial);
    }//GEN-LAST:event_txt_codigoClienteInicialFocusGained

    private void txt_codigoClienteFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFinalFocusGained
        new SelecaoDeCampo(null, txt_codigoClienteFinal);
    }//GEN-LAST:event_txt_codigoClienteFinalFocusGained

    private void txt_dataContratoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataContratoInicialFocusGained
        new SelecaoDeCampo(null, txt_dataContratoInicial);
    }//GEN-LAST:event_txt_dataContratoInicialFocusGained

    private void txt_dataContratoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataContratoFinalFocusGained
        new SelecaoDeCampo(null, txt_dataContratoFinal);
    }//GEN-LAST:event_txt_dataContratoFinalFocusGained

    private void txt_codigoUsuarioInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioInicialFocusGained
        new SelecaoDeCampo(null, txt_codigoUsuarioInicial);
    }//GEN-LAST:event_txt_codigoUsuarioInicialFocusGained

    private void txt_codigoUsuarioFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioFinalFocusGained
        new SelecaoDeCampo(null, txt_codigoUsuarioFinal);
    }//GEN-LAST:event_txt_codigoUsuarioFinalFocusGained

    private void txt_dataCadastroInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroInicialFocusGained
        new SelecaoDeCampo(null, txt_dataCadastroInicial);
    }//GEN-LAST:event_txt_dataCadastroInicialFocusGained

    private void txt_dataCadastroFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroFinalFocusGained
        new SelecaoDeCampo(null, txt_dataCadastroFinal);
    }//GEN-LAST:event_txt_dataCadastroFinalFocusGained

    private void txt_dataVencimentoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVencimentoInicialFocusGained
        new SelecaoDeCampo(null, txt_dataVencimentoInicial);
    }//GEN-LAST:event_txt_dataVencimentoInicialFocusGained

    private void txt_dataVencimentoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVencimentoFinalFocusGained
        new SelecaoDeCampo(null, txt_dataVencimentoFinal);
    }//GEN-LAST:event_txt_dataVencimentoFinalFocusGained

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TableContratos  = (DefaultTableModel)tabela_contratos.getModel();
        InicializaCampos();
        if(bc.codigoCliente != 0){
            txt_codigoClienteInicial    .setText(fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0));
            txt_codigoClienteFinal      .setText(fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0));
            txt_codigoClienteInicial    .setEditable(false);
            txt_codigoClienteFinal      .setEditable(false);
            txt_codigoClienteInicial    .setFocusable(false);
            txt_codigoClienteFinal      .setFocusable(false);
            bt_pesquisaClienteInicial   .setEnabled(false);
            bt_pesquisaClienteFinal     .setEnabled(false);
        }
        PegaValores();
    }//GEN-LAST:event_formWindowOpened

    private void bt_pesquisaClienteInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteInicialActionPerformed
        Campo = "I";
        PesquisaCliente();
    }//GEN-LAST:event_bt_pesquisaClienteInicialActionPerformed
    
    private void PesquisaCliente(){
        if(CliCon != null)if(CliCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuCliente = 1;
        CliCon = new ClientesConsulta("N");
        CliCon.setVisible(true);
    }
    
    private void bt_pesquisaClienteFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteFinalActionPerformed
        Campo = "F";
        PesquisaCliente();
    }//GEN-LAST:event_bt_pesquisaClienteFinalActionPerformed

    private void bt_pesquisaUsuarioInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaUsuarioInicialActionPerformed
        Campo = "I";
        PesquisaUsuario();
    }//GEN-LAST:event_bt_pesquisaUsuarioInicialActionPerformed
    
    private void PesquisaUsuario(){
        parametros.clear();
        parametros.add("N");
        if(UsuCon != null)if(UsuCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuUsuario = 1;
        UsuCon = new UsuariosConsulta(parametros);
        UsuCon.setVisible(true);
    }
    
    private void bt_pesquisaUsuarioFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaUsuarioFinalActionPerformed
        Campo = "F";
        PesquisaUsuario();
    }//GEN-LAST:event_bt_pesquisaUsuarioFinalActionPerformed
    
    private void PesquisaManutencao(){
        parametros.clear();
        parametros.add("N");
        if(ManCon != null)if(ManCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuManutencao = 1;
        ManCon = new ManutencoesConsulta(parametros);
        ManCon.setVisible(true);
    }
    
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuCliente == 0){
            AbreUsuarios();
            return;
        }
        abriuCliente = 0;
        retorno = CliCon.getRetorno();
        if(retorno.equals(""))
            return;
        if(Campo.equals("I")){
            txt_codigoClienteInicial.setText(fc.FormataCampo(retorno, 5, 0));
            return;
        }
        txt_codigoClienteFinal.setText(fc.FormataCampo(retorno, 5, 0));
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(CliCon   != null)CliCon.dispose();
        if(UsuCon   != null)UsuCon.dispose();
        if(ManCon   != null)ManCon.dispose();
    }//GEN-LAST:event_formWindowClosed
    
    private void AbreUsuarios(){
        if(abriuUsuario == 0)
            return;
        abriuUsuario = 0;
        retorno = UsuCon.getRetorno();
        if(retorno.equals(""))
            return;
        if(Campo.equals("I")){
            txt_codigoUsuarioInicial.setText(fc.FormataCampo(retorno, 3, 0));
            return;
        }
        txt_codigoUsuarioFinal.setText(fc.FormataCampo(retorno, 3, 0));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_detalhesItem;
    private javax.swing.JButton bt_pesquisaClienteFinal;
    private javax.swing.JButton bt_pesquisaClienteInicial;
    private javax.swing.JButton bt_pesquisaUsuarioFinal;
    private javax.swing.JButton bt_pesquisaUsuarioInicial;
    private javax.swing.JButton bt_processa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_contratos;
    private javax.swing.JFormattedTextField txt_codigoClienteFinal;
    private javax.swing.JFormattedTextField txt_codigoClienteInicial;
    private javax.swing.JFormattedTextField txt_codigoContratoFinal;
    private javax.swing.JFormattedTextField txt_codigoContratoInicial;
    private javax.swing.JFormattedTextField txt_codigoUsuarioFinal;
    private javax.swing.JFormattedTextField txt_codigoUsuarioInicial;
    private javax.swing.JFormattedTextField txt_dataCadastroFinal;
    private javax.swing.JFormattedTextField txt_dataCadastroInicial;
    private javax.swing.JFormattedTextField txt_dataContratoFinal;
    private javax.swing.JFormattedTextField txt_dataContratoInicial;
    private javax.swing.JFormattedTextField txt_dataVencimentoFinal;
    private javax.swing.JFormattedTextField txt_dataVencimentoInicial;
    private javax.swing.JTextField txt_descricaoContrato;
    private javax.swing.JTextField txt_quantidadeRegistros;
    // End of variables declaration//GEN-END:variables
    
    public String getRetornoContrato(){
        return retorno;
    }
    
    private void PegaCliente(){
        bc.nome = "----------";
        sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
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
        }
    }
    
    private void PegaUsuario(){
        bu.usuario = "----------";
        sql = "select usuario from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuario.clear();
        dadosUsuario = parametrosNS.dao.Consulta(sql);
        if(dadosUsuario.isEmpty())
            return;
        PegaDadosUsuario();
    }
    
    private void PegaDadosUsuario(){
        for(int i = 0; i < dadosUsuario.size(); i++)
            bu.usuario = String.valueOf(dadosUsuario.get(i).get(0));
    }
    
}
