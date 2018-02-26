package TelasRecebimento;

import Beans.BeanClientes;
import Beans.BeanFormasPagamentos;
import Beans.BeanParametros;
import Beans.BeanRecibos;
import Beans.BeanRecibosDetalhes;
import Beans.BeanRecibosPagamentos;
import Beans.BeanServicos;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCPFCNPJ;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.FormataCampoCpfCnpj;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.PegaProximoRegistro;
import FuncoesInternas.TransformaValorStringeDouble;
import TelasFaturamento.ClientesConsulta;
import TelasProducao.ServicoConsulta;
import Parametros.parametrosNS;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/*
 @author Tiago e Paulo 05/11/2016
 */
public class RecibosCadastro extends javax.swing.JFrame {
    //String
    String sql                              = "";
    String sqlstate                         = "";
    String mensagem                         = "";
    String retorno                          = "";
    String fatal                            = "";
    String operacao                         = "";
    String somostra                         = "";
    String CpfNaNota                        = "";
    
    //Int
    int    abriuCliente                     = 0;
    int    abriuServico                     = 0;
    int    abriuPesquisaRecibo              = 0;
    int    quantidade                       = 0;
    int    Linha                            = 0;
    int    Confirmacao                      = 0;
    int    LinhaItensJaInclusos             = 0;
    int    QtdItensPagos                    = 0;
    
    //Float
    double ValorTotal                       = 0;
    double ValorTotalRecibo                 = 0;
    double ValorRestante                    = 0;
    double ValorTotalItens                  = 0;
    double ValorTotalPago                   = 0;
    
    //Vetores
    ArrayList            parametros                     = new ArrayList();
    ArrayList            dadosPadroes                   = new ArrayList();
    ArrayList<ArrayList> dadosCount                     = new ArrayList();
    ArrayList<ArrayList> dadosCliente                   = new ArrayList();
    ArrayList<ArrayList> dadosFormasPagamentos          = new ArrayList();
    ArrayList<ArrayList> dadosRecibos                   = new ArrayList();
    ArrayList<ArrayList> dadosRecibosDetalhes           = new ArrayList();
    ArrayList<ArrayList> dadosRecibosPagamentos         = new ArrayList();
    ArrayList<ArrayList> dadosParametros                = new ArrayList();
    ArrayList<ArrayList> dadosServicos                  = new ArrayList();
    
    //Beans
    BeanRecibos                     br      = new BeanRecibos();
    BeanRecibosDetalhes             brd     = new BeanRecibosDetalhes();
    BeanRecibosPagamentos           brp     = new BeanRecibosPagamentos();
    BeanFormasPagamentos            bfp     = new BeanFormasPagamentos();
    BeanClientes                    bc      = new BeanClientes();
    BeanParametros                  bpar    = new BeanParametros();
    BeanServicos                    bser    = new BeanServicos();
    
    //Telas
    ClientesConsulta                CliCon;
    ServicoConsulta                 SerCon;
    RecibosConsulta                 RecCon;
    
    //Funções
    InverterData                    invdata         = new InverterData();
    FormataCPFCNPJ                  FCpfCnpj        = new FormataCPFCNPJ();
    FormataCampo                    fc              = new FormataCampo();
    FormataCampoCpfCnpj             FCampoCpfCnpj   = new FormataCampoCpfCnpj();
    CapturarDataHora                cdh             = new CapturarDataHora();
    PegaProximoRegistro             PegProReg       = new PegaProximoRegistro();
    TransformaValorStringeDouble    TransStrDou     = new TransformaValorStringeDouble();
    DefaultTableModel               TableItens;
    DefaultTableModel               TablePagamento;
    
    //Especiais para Relatórios
    String                  jpv         = "";
    JasperPrint             jpp         = null;
    HashMap                 hm          = new HashMap();
    JRPrintPage             jrp         = null;
    List                    QtdPages    = null;
    
    //Jasper
    String         arquivoJasper = "";
    JasperPrint    rel           = null;
    HashMap        map           = new HashMap();
    
    //Especiais
    BufferedImage                   BuffImg;
    ByteArrayOutputStream           BytesImg;
    ImageIcon                       ImgIcon;
    Image                           Img;
    
    public RecibosCadastro(ArrayList DadosPadroes){
        dadosPadroes                                = DadosPadroes;
        
        somostra                                    = (String)  dadosPadroes.get(0);
        br.codigoRecibo                             = (int)     dadosPadroes.get(1);
        
        initComponents();
    }
    
    private void PegaParametros(){
        sql = "select * from tb_parametros where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametros.clear();
        dadosParametros = parametrosNS.dao.Consulta(sql);
        if(dadosParametros.isEmpty()){
            bt_imprimir.setVisible(false);
            return;
        }
        PegaDadosParametros();
    }
    
    private void PegaDadosParametros(){
        for(int i = 0; i < dadosParametros.size(); i++){
            bpar.idParametros       = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(0)));
            bpar.idEmpresa          = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(1)));
            bpar.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(2)));
            bpar.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(3)));
            bpar.pastaRelatorios    =                    String.valueOf(dadosParametros.get(i).get(4));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_removerItem = new javax.swing.JMenuItem();
        bt_limparItens = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bt_novo = new javax.swing.JButton();
        txt_codigoRecibo = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txt_codigoCliente = new javax.swing.JFormattedTextField();
        label_cliente = new javax.swing.JLabel();
        bt_pesquisaCliente = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txt_cpfcnpj1 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj2 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj3 = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela_itens = new javax.swing.JTable();
        bt_pesquisa = new javax.swing.JButton();
        bt_imprimir = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bt_pesquisaServico = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_valorUnitario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_quantidade = new javax.swing.JTextField();
        txt_valorTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_codigoServico = new javax.swing.JFormattedTextField();
        label_descricao = new javax.swing.JLabel();
        bt_adicionaServico = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observacoes = new javax.swing.JTextArea();
        bt_finalizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_pagamento = new javax.swing.JTable();
        combo_Pagamento = new javax.swing.JComboBox<>();
        txt_valor = new javax.swing.JTextField();
        txt_valorRestante = new javax.swing.JTextField();
        txt_valorAPagar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        bt_removerItem.setText("Remover Item");
        bt_removerItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_removerItemActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_removerItem);

        bt_limparItens.setText("Limpar Itens");
        bt_limparItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_limparItensActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_limparItens);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Recibos");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Código do Recibo");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        try {
            txt_codigoRecibo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoRecibo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoRecibo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoReciboFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoReciboFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, txt_codigoRecibo});

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Cliente");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoClienteFocusLost(evt);
            }
        });
        txt_codigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoClienteActionPerformed(evt);
            }
        });
        txt_codigoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoClienteKeyReleased(evt);
            }
        });

        label_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_clienteMouseEntered(evt);
            }
        });

        bt_pesquisaCliente.setText("...");
        bt_pesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_pesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(label_cliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaCliente, label_cliente, txt_codigoCliente});

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("CPF ou CNPJ");
        jLabel35.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_cpfcnpj1.setEditable(false);
        try {
            txt_cpfcnpj1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpfcnpj1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpfcnpj1.setFocusable(false);
        txt_cpfcnpj1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj1FocusLost(evt);
            }
        });
        txt_cpfcnpj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cpfcnpj1ActionPerformed(evt);
            }
        });
        txt_cpfcnpj1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cpfcnpj1KeyReleased(evt);
            }
        });

        txt_cpfcnpj2.setEditable(false);
        try {
            txt_cpfcnpj2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpfcnpj2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpfcnpj2.setFocusable(false);
        txt_cpfcnpj2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj2FocusLost(evt);
            }
        });
        txt_cpfcnpj2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cpfcnpj2ActionPerformed(evt);
            }
        });

        txt_cpfcnpj3.setEditable(false);
        try {
            txt_cpfcnpj3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpfcnpj3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpfcnpj3.setFocusable(false);
        txt_cpfcnpj3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj3FocusLost(evt);
            }
        });
        txt_cpfcnpj3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cpfcnpj3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_cpfcnpj1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cpfcnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cpfcnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_cpfcnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_cpfcnpj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_cpfcnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Descrições dos Serviços");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_itens.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seq", "Código Serviço", "Valor", "Quantidade", "Valor total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_itens.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_itens.getTableHeader().setReorderingAllowed(false);
        tabela_itens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_itensMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabela_itens);
        if (tabela_itens.getColumnModel().getColumnCount() > 0) {
            tabela_itens.getColumnModel().getColumn(0).setResizable(false);
            tabela_itens.getColumnModel().getColumn(1).setResizable(false);
            tabela_itens.getColumnModel().getColumn(2).setResizable(false);
            tabela_itens.getColumnModel().getColumn(3).setResizable(false);
            tabela_itens.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bt_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisa.setText("Pesquisa");
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaActionPerformed(evt);
            }
        });

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.setEnabled(false);
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Itens");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Código: ");

        bt_pesquisaServico.setText("...");
        bt_pesquisaServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaServicoActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Valor unitário: ");

        txt_valorUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorUnitarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorUnitarioFocusLost(evt);
            }
        });

        jLabel10.setText("Quantidade: ");

        txt_quantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantidadeFocusLost(evt);
            }
        });
        txt_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_quantidadeKeyPressed(evt);
            }
        });

        txt_valorTotal.setEditable(false);
        txt_valorTotal.setFocusable(false);

        jLabel11.setText("Valor total: ");

        try {
            txt_codigoServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoServico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoServicoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoServicoFocusLost(evt);
            }
        });
        txt_codigoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoServicoActionPerformed(evt);
            }
        });
        txt_codigoServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoServicoKeyPressed(evt);
            }
        });

        label_descricao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        bt_adicionaServico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_adicionaServico.setText("Adicionar");
        bt_adicionaServico.setEnabled(false);
        bt_adicionaServico.setFocusable(false);
        bt_adicionaServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_adicionaServicoActionPerformed(evt);
            }
        });
        bt_adicionaServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_adicionaServicoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_codigoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaServico, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_descricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_valorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_adicionaServico)
                        .addGap(0, 184, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel6, jLabel9});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(bt_pesquisaServico, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_valorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_adicionaServico, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaServico, jLabel6, label_descricao, txt_codigoServico});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_adicionaServico, jLabel10, jLabel11, jLabel9, txt_quantidade, txt_valorTotal, txt_valorUnitario});

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Observações");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_observacoes.setColumns(20);
        txt_observacoes.setRows(5);
        jScrollPane1.setViewportView(txt_observacoes);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bt_finalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/vend.png"))); // NOI18N
        bt_finalizar.setText("Finalizar");
        bt_finalizar.setEnabled(false);
        bt_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_finalizarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pagamento");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_pagamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_pagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pagamento", "Valor", "Troco"
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
        tabela_pagamento.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_pagamento.getTableHeader().setReorderingAllowed(false);
        tabela_pagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_pagamentoMouseClicked(evt);
            }
        });
        tabela_pagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabela_pagamentoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_pagamento);
        if (tabela_pagamento.getColumnModel().getColumnCount() > 0) {
            tabela_pagamento.getColumnModel().getColumn(0).setResizable(false);
            tabela_pagamento.getColumnModel().getColumn(0).setPreferredWidth(165);
            tabela_pagamento.getColumnModel().getColumn(1).setResizable(false);
            tabela_pagamento.getColumnModel().getColumn(2).setResizable(false);
        }

        combo_Pagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        combo_Pagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_PagamentoKeyReleased(evt);
            }
        });

        txt_valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorFocusLost(evt);
            }
        });
        txt_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_valorKeyReleased(evt);
            }
        });

        txt_valorRestante.setEnabled(false);

        txt_valorAPagar.setEditable(false);
        txt_valorAPagar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Valor a Pagar:");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Valor restante:");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Valor:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tipo de Pagamento:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_Pagamento, 0, 152, Short.MAX_VALUE)
                    .addComponent(txt_valorAPagar)
                    .addComponent(txt_valorRestante)
                    .addComponent(txt_valor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel12, jLabel13, jLabel5});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(combo_Pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_valorRestante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_valorAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(1, 1, 1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_Pagamento, jLabel12, jLabel13, jLabel5});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel7, txt_valorAPagar, txt_valorRestante});

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenu2.setText("Cadastros");
        jMenu1.add(jMenu2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(bt_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_imprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_imprimir, bt_pesquisa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_finalizar, bt_imprimir, bt_pesquisa, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFocusGained
        if(txt_codigoCliente.isEditable() == false)
            return;
        if(somostra.equalsIgnoreCase("S"))
            return;
        txt_codigoCliente.setText("");
        label_cliente    .setText("");
        txt_cpfcnpj1     .setText("");
        txt_cpfcnpj2     .setText("");
        txt_cpfcnpj3     .setText("");
    }//GEN-LAST:event_txt_codigoClienteFocusGained

    private void txt_codigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFocusLost
        if(txt_codigoCliente.isEditable() == false)
            return;
        if(txt_codigoCliente.getText().replace(" ", "").equals(""))
            return;
        if(txt_codigoRecibo.getText().replace(" ", "").equals(""))
            return;
        PegaCliente();
    }//GEN-LAST:event_txt_codigoClienteFocusLost

    private void txt_codigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoClienteActionPerformed
        
    }//GEN-LAST:event_txt_codigoClienteActionPerformed

    private void txt_codigoClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoClienteKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_codigoServico.grabFocus();
    }//GEN-LAST:event_txt_codigoClienteKeyReleased

    private void label_clienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_clienteMouseEntered
        label_cliente.setToolTipText(label_cliente.getText());
    }//GEN-LAST:event_label_clienteMouseEntered
    
    private void bt_pesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteActionPerformed
        if(CliCon != null)if(CliCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuCliente = 1;
        CliCon = new ClientesConsulta("N");
        CliCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaClienteActionPerformed

    private void txt_cpfcnpj1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1FocusGained
        txt_cpfcnpj1.setText("");
    }//GEN-LAST:event_txt_cpfcnpj1FocusGained

    private void txt_cpfcnpj1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1FocusLost

    }//GEN-LAST:event_txt_cpfcnpj1FocusLost

    private void txt_cpfcnpj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1ActionPerformed
        
    }//GEN-LAST:event_txt_cpfcnpj1ActionPerformed

    private void txt_cpfcnpj1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1KeyReleased
        
    }//GEN-LAST:event_txt_cpfcnpj1KeyReleased

    private void txt_cpfcnpj2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj2FocusLost

    }//GEN-LAST:event_txt_cpfcnpj2FocusLost

    private void txt_cpfcnpj2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfcnpj2ActionPerformed
        
    }//GEN-LAST:event_txt_cpfcnpj2ActionPerformed

    private void txt_cpfcnpj3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj3FocusLost

    }//GEN-LAST:event_txt_cpfcnpj3FocusLost

    private void txt_cpfcnpj3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfcnpj3ActionPerformed
        
    }//GEN-LAST:event_txt_cpfcnpj3ActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(RecCon != null)if(RecCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuPesquisaRecibo = 1;
        RecCon = new RecibosConsulta("S");
        RecCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        ImprimirRecibo();
    }//GEN-LAST:event_bt_imprimirActionPerformed

    private void bt_pesquisaServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaServicoActionPerformed
        if(SerCon != null)if(SerCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuServico = 1;
        parametros.clear();
        parametros.add("N");
        SerCon = new ServicoConsulta(parametros);
        SerCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaServicoActionPerformed

    private void txt_quantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantidadeFocusLost
        if(somostra.equals("S"))return;
        if(br.status == 1)return;
        if(br.status == 3)return;
        if(txt_quantidade.isEditable() == false)return;
        if(txt_quantidade.getText().replace(" ", "").equals("")){
            brd.quantidade = 0;
            return;
        }
        try{
            brd.quantidade      = Integer.parseInt(txt_quantidade.getText());
        }catch(Exception erro){
            mensagem = "Quantidade inválida!";
            new MostraMensagem(mensagem);
            return;
        }
        brd.valorServico                = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorUnitario.getText(), 1));
        brd.valorTotal                  = brd.valorServico * brd.quantidade;
        bt_adicionaServico.setFocusable(true);
        bt_adicionaServico.setEnabled(true);
        bt_adicionaServico.grabFocus();
        txt_valorTotal.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(brd.valorTotal), 0));
    }//GEN-LAST:event_txt_quantidadeFocusLost

    private void txt_quantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_quantidadeKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        bt_adicionaServico.setFocusable(true);
        bt_adicionaServico.grabFocus();
    }//GEN-LAST:event_txt_quantidadeKeyPressed

    private void txt_codigoServicoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoServicoFocusGained
        if(txt_codigoServico.isEditable() == false)
            return;
        txt_codigoServico   .setText("");
        label_descricao     .setText("");
        txt_valorUnitario   .setText("");
        txt_quantidade      .setText("");
        txt_valorTotal      .setText("");
    }//GEN-LAST:event_txt_codigoServicoFocusGained

    private void txt_codigoServicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoServicoFocusLost
        if(txt_codigoServico.isEditable() == false)
            return;
        if(txt_codigoServico.getText().replace(" ", "").equals(""))
            return;
        if(somostra.equals("S"))
            return;
        if(br.status == 1)
            return;
        if(br.status == 3)
            return;
        txt_codigoServico.setText(fc.FormataCampo(txt_codigoServico.getText().replace(" ", ""), 6, 0));
        bser.codigoServico = Integer.parseInt(txt_codigoServico.getText());
        if(bser.codigoServico == 0)
            return;
        PegaServicos();
        if(fatal.equals("S"))return;
        label_descricao.setText(bser.descricaoServico);
        txt_valorUnitario.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bser.valorServico), 0));
        txt_quantidade.setText("");
        txt_valorTotal.setText("");
        txt_quantidade.grabFocus();
    }//GEN-LAST:event_txt_codigoServicoFocusLost

    private void txt_codigoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoServicoActionPerformed

    private void txt_codigoServicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoServicoKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_quantidade.grabFocus();
    }//GEN-LAST:event_txt_codigoServicoKeyPressed

    private void tabela_pagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_pagamentoMouseClicked
//        Linha   = tabela_pagamento.getSelectedRow();
//        if(Linha < 0){
//            mensagem = "Item não selecionado!";
//            new MostraMensagem(mensagem);
//            return;
//        }
//        if(evt.getButton() == MouseEvent.BUTTON3){
//            MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
//        }
    }//GEN-LAST:event_tabela_pagamentoMouseClicked

    private void tabela_pagamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabela_pagamentoKeyPressed

    }//GEN-LAST:event_tabela_pagamentoKeyPressed

    private void txt_valorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorFocusGained
        if(!txt_valor.getText().equals(""))
            txt_valor.setText(TransStrDou.TransformaValorStringeDouble(txt_valor.getText(), 1));
        txt_valor.setSelectionStart(0);
        txt_valor.setSelectionEnd  (txt_valor.getText().length());
    }//GEN-LAST:event_txt_valorFocusGained

    private void txt_valorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorFocusLost
        if(!txt_valor.getText().equals(""))
            txt_valor.setText(TransStrDou.TransformaValorStringeDouble(txt_valor.getText(), 0));
    }//GEN-LAST:event_txt_valorFocusLost

    private void txt_valorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        PagamentosRecibos();
    }//GEN-LAST:event_txt_valorKeyReleased

    private void combo_PagamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_PagamentoKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_valor.grabFocus();
    }//GEN-LAST:event_combo_PagamentoKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TableItens      = (DefaultTableModel)tabela_itens.getModel();
        TablePagamento  = (DefaultTableModel)tabela_pagamento.getModel();
        PegaFormasDePagamentos("S");
        PegaParametros();
        
        tabela_itens.getColumnModel().getColumn(0).setResizable(false);
        tabela_itens.getColumnModel().getColumn(0).setPreferredWidth(5);
        tabela_itens.getColumnModel().getColumn(1).setResizable(false);
        tabela_itens.getColumnModel().getColumn(1).setPreferredWidth(350);
        tabela_itens.getColumnModel().getColumn(2).setResizable(false);
        tabela_itens.getColumnModel().getColumn(3).setResizable(false);
        tabela_itens.getColumnModel().getColumn(4).setResizable(false);
        
        if(somostra.equalsIgnoreCase("S")){
            txt_codigoRecibo            .setEditable    (false);
            txt_codigoRecibo            .setFocusable   (false);
            bt_novo                     .setEnabled     (false);
            txt_codigoCliente           .setEditable    (false);
            txt_codigoCliente           .setFocusable   (false);
            bt_pesquisaCliente          .setEnabled     (false);
            txt_codigoServico           .setEditable    (false);
            txt_codigoServico           .setFocusable   (false);
            bt_pesquisaServico          .setEnabled     (false);
            bt_pesquisa                 .setVisible     (false);
            combo_Pagamento             .setEnabled     (false);
            combo_Pagamento             .setFocusable   (false);
            txt_valor                   .setEditable    (false);
            txt_valor                   .setFocusable   (false);
            bt_imprimir                 .setVisible     (false);
        }
        if(somostra.equalsIgnoreCase("SN"))
            bt_pesquisa                 .setVisible     (false);
        if(br.codigoRecibo != 0){
            txt_codigoRecibo.setText(String.valueOf(br.codigoRecibo));
            PegaRecibos();
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuCliente == 0){
            AbreServicos();
            return;
        }
        abriuCliente = 0;
        retorno = CliCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoCliente.setText(retorno);
        PegaCliente();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbreServicos(){
        if(abriuServico == 0){
            AbreConsultaRecibos();
            return;
        }
        abriuServico = 0;
        retorno = SerCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoServico.setText(fc.FormataCampo(retorno, 6, 0));
        bser.codigoServico  = Integer.parseInt(retorno);
        PegaServicos();
        if(fatal.equals("S"))return;
        label_descricao.setText(bser.descricaoServico);
        txt_valorUnitario.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bser.valorServico), 0));
        txt_quantidade.setText("");
        txt_valorTotal.setText("");
        txt_quantidade.grabFocus();
    }
    
    private void AbreConsultaRecibos(){
        if(abriuPesquisaRecibo == 0)
            return;
        abriuPesquisaRecibo = 0;
        retorno = RecCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoRecibo.setText(retorno);
        PegaRecibos();
    }
    
    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        NovoRecibo();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_adicionaServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_adicionaServicoActionPerformed
        InserirReciboeDetalhes();
    }//GEN-LAST:event_bt_adicionaServicoActionPerformed
    
    private void InserirReciboeDetalhes(){
        if(somostra.equals("S"))
            return;
        if(operacao.equals("I")){
            IncluirRecibo();
            if(fatal.equals("S"))return;
        }
        IncluirReciboDetalhes();
    }
    
    private void bt_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_finalizarActionPerformed
        FinalizarRecibo();
    }//GEN-LAST:event_bt_finalizarActionPerformed

    private void tabela_itensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_itensMouseClicked
        Linha = tabela_itens.getSelectedRow();
        if(Linha < 0){
            mensagem = "Item não Selecionado!";
            new MostraMensagem(mensagem);
            return;
        }
        if(evt.getButton() == MouseEvent.BUTTON3){
            if(somostra.equalsIgnoreCase("N")){
                if(br.status > 0)bt_limparItens.setVisible(false);
                if(Linha + 1 > QtdItensPagos)
                    MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_tabela_itensMouseClicked

    private void bt_removerItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_removerItemActionPerformed
        RemoverItem();
    }//GEN-LAST:event_bt_removerItemActionPerformed

    private void bt_limparItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_limparItensActionPerformed
        LimparTabelaDeItens();
    }//GEN-LAST:event_bt_limparItensActionPerformed

    private void txt_codigoReciboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoReciboFocusLost
        if(txt_codigoRecibo.isEditable() == false)
            return;
        if(txt_codigoRecibo.getText().replace(" ", "").equals(""))
            return;
        PegaRecibos();
    }//GEN-LAST:event_txt_codigoReciboFocusLost

    private void txt_codigoReciboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoReciboFocusGained
        if(txt_codigoRecibo.isEditable() == false)
            return;
        if(somostra.equalsIgnoreCase("S"))
            return;
        ReiniciaCampos();
    }//GEN-LAST:event_txt_codigoReciboFocusGained

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_adicionaServicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_adicionaServicoKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        InserirReciboeDetalhes();
    }//GEN-LAST:event_bt_adicionaServicoKeyPressed

    private void txt_valorUnitarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorUnitarioFocusGained
        if(txt_valorUnitario.isEditable() == false)
            return;
        if(!txt_valorUnitario.getText().equals(""))
            txt_valorUnitario.setText(TransStrDou.TransformaValorStringeDouble(txt_valorUnitario.getText(), 1));
    }//GEN-LAST:event_txt_valorUnitarioFocusGained

    private void txt_valorUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorUnitarioFocusLost
        if(txt_valorUnitario.isEditable() == false)
            return;
        if(!txt_valorUnitario.getText().equals(""))
            txt_valorUnitario.setText(TransStrDou.TransformaValorStringeDouble(txt_valorUnitario.getText(), 0));
    }//GEN-LAST:event_txt_valorUnitarioFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JButton bt_adicionaServico;
    private javax.swing.JButton bt_finalizar;
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JMenuItem bt_limparItens;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_pesquisaCliente;
    private javax.swing.JButton bt_pesquisaServico;
    private javax.swing.JMenuItem bt_removerItem;
    private javax.swing.JButton bt_sair;
    private javax.swing.JComboBox<String> combo_Pagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_cliente;
    private javax.swing.JLabel label_descricao;
    private javax.swing.JTable tabela_itens;
    private javax.swing.JTable tabela_pagamento;
    private javax.swing.JFormattedTextField txt_codigoCliente;
    private javax.swing.JFormattedTextField txt_codigoRecibo;
    private javax.swing.JFormattedTextField txt_codigoServico;
    private javax.swing.JFormattedTextField txt_cpfcnpj1;
    private javax.swing.JFormattedTextField txt_cpfcnpj2;
    private javax.swing.JFormattedTextField txt_cpfcnpj3;
    private javax.swing.JTextArea txt_observacoes;
    private javax.swing.JTextField txt_quantidade;
    private javax.swing.JTextField txt_valor;
    private javax.swing.JTextField txt_valorAPagar;
    private javax.swing.JTextField txt_valorRestante;
    private javax.swing.JTextField txt_valorTotal;
    private javax.swing.JTextField txt_valorUnitario;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void ReiniciaCampos(){
        br  = new BeanRecibos();
        brd = new BeanRecibosDetalhes();
        brp = new BeanRecibosPagamentos();
        dadosRecibos            .clear();
        dadosRecibosDetalhes    .clear();
        dadosRecibosPagamentos  .clear();
        txt_codigoRecibo        .setText("");
        txt_codigoCliente       .setText("");
        label_cliente           .setText("");
        txt_cpfcnpj1            .setText("");
        txt_cpfcnpj2            .setText("");
        txt_cpfcnpj3            .setText("");
        txt_codigoServico       .setText("");
        txt_valorUnitario       .setText("");
        txt_quantidade          .setText("");
        txt_valorTotal          .setText("");
        bt_adicionaServico      .setFocusable(false);
        bt_adicionaServico      .setEnabled(false);
        TableItens              .setNumRows(0);
        txt_observacoes         .setText("");
        combo_Pagamento         .setSelectedIndex(0);
        combo_Pagamento         .setEnabled(true);
        txt_valor               .setText("");
        txt_valor               .setEditable(true);
        txt_valorRestante       .setText("");
        txt_valorAPagar         .setText(TransStrDou.TransformaValorStringeDouble("0", 0));
        TablePagamento          .setNumRows(0);
        bt_finalizar            .setEnabled(false);
        bt_imprimir             .setEnabled(false);
    }
    
    private void NovoRecibo(){
        ReiniciaCampos();
        txt_codigoCliente.grabFocus();
        
        br.codigoRecibo = PegProReg.PegaProximoRegistro("tb_recibos", "codigoRecibo", "");
        txt_codigoRecibo.setText(fc.FormataCampo(String.valueOf(br.codigoRecibo), 6, 0));
        
        operacao = "I";
    }

    private void PegaFormasDePagamentos(String Add){
        sql = "select codigoPagamento, descricaoPagamento from tb_formaspagamentos where idEmpresa = " + parametrosNS.be.IdEmpresa;
        if(Add.equals("N"))
            sql += " and codigoPagamento = " + bfp.codigoPagamento;
        sql += ";";
        dadosFormasPagamentos.clear();
        dadosFormasPagamentos = parametrosNS.dao.Consulta(sql);
        if(dadosFormasPagamentos.isEmpty()){
            mensagem = "Não foram encontrado formas de pagamentos cadastradas!";
            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosFormasDePagamentos(Add);
    }
    
    private void PegaDadosFormasDePagamentos(String Add){
        if(Add.equals("S")){
            combo_Pagamento.removeAllItems();
            combo_Pagamento.addItem("");
        }
        for(int i = 0; i < dadosFormasPagamentos.size(); i++){
            bfp = new BeanFormasPagamentos();
//            bfp.idPagamento             = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(0)));
//            bfp.idEmpresa               = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(1)));
//            bfp.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(2)));
//            bfp.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(3)));
            bfp.codigoPagamento         = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(0)));
            bfp.descricaoPagamento      =                    String.valueOf(dadosFormasPagamentos.get(i).get(1));
            
            if(Add.equals("S"))
                combo_Pagamento.addItem(fc.FormataCampo(String.valueOf(bfp.codigoPagamento), 2, 0) + "-" + bfp.descricaoPagamento);
        }
    }
    
    private void PegaCliente(){
        txt_codigoCliente.setText(fc.FormataCampo(txt_codigoCliente.getText(), 5, 0));
        bc.codigoCliente    = Integer.parseInt(txt_codigoCliente.getText());
        if(bc.codigoCliente == 0){
            label_cliente.setText("");
            return;
        }
        sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome, cpfCnpj from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = '" + bc.codigoCliente + "';";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            mensagem = "Cliente " + bc.codigoCliente + " não encontrado!";
            new MostraMensagem(mensagem);
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
        }
        label_cliente.setText(bc.nome);
        bc.cpfCnpj      = FCampoCpfCnpj.FormataCampoCpfCnpj(bc.cpfCnpj);
        bc.cpfCnpj1     = bc.cpfCnpj.substring(0 , 9);
        bc.cpfCnpj2     = bc.cpfCnpj.substring(9 ,13);
        bc.cpfCnpj3     = bc.cpfCnpj.substring(13,15);
        txt_cpfcnpj1.setText(bc.cpfCnpj1);
        txt_cpfcnpj2.setText(bc.cpfCnpj2);
        txt_cpfcnpj3.setText(bc.cpfCnpj3);
        txt_codigoServico.grabFocus();
    }
    
    private void PegaServicos(){
        fatal = "N";
        sql = "select * from tb_servicos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoServico = " + bser.codigoServico + ";";
        dadosServicos.clear();
        dadosServicos = parametrosNS.dao.Consulta(sql);
        if(dadosServicos.isEmpty()){
            mensagem = "Serviço código " + bser.codigoServico + " não encontrado!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        PegaDadosServicos();
    }
    
    private void PegaDadosServicos(){
        for(int i = 0; i < dadosServicos.size(); i++){
            if(dadosServicos.get(i).get(0) != null)
                bser.idServico          = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(0)));
            if(dadosServicos.get(i).get(1) != null)
                bser.idEmpresa          = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(1)));
            if(dadosServicos.get(i).get(2) != null)
                bser.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(2)));
            if(dadosServicos.get(i).get(3) != null)
                bser.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(3)));
            if(dadosServicos.get(i).get(4) != null)
                bser.codigoServico      = Integer.parseInt(  String.valueOf(dadosServicos.get(i).get(4)));
                bser.descricaoServico   =                    String.valueOf(dadosServicos.get(i).get(5));
            if(dadosServicos.get(i).get(6) != null)
                bser.valorServico       = Double.parseDouble(String.valueOf(dadosServicos.get(i).get(6)));
        }
    }
    
    private void PegaRecibos(){
        txt_codigoRecibo.setText(fc.FormataCampo(txt_codigoRecibo.getText().replace(" ", ""), 6, 0));
        br.codigoRecibo     = Integer.parseInt(txt_codigoRecibo.getText());
        if(br.codigoRecibo == 0)
            return;
        sql = "select * from tb_recibos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoRecibo = " + br.codigoRecibo + ";";
        dadosRecibos.clear();
        dadosRecibos = parametrosNS.dao.Consulta(sql);
        if(dadosRecibos.isEmpty()){
            mensagem = "Não foi encontrado o Recibo n°" + br.codigoRecibo + "!";
            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosRecibos();
    }
    
    private void PegaDadosRecibos(){
        tabela_itens.getColumnModel().getColumn(0).setResizable(false);
        tabela_itens.getColumnModel().getColumn(0).setPreferredWidth(5);
        tabela_itens.getColumnModel().getColumn(1).setResizable(false);
        tabela_itens.getColumnModel().getColumn(1).setPreferredWidth(350);
        tabela_itens.getColumnModel().getColumn(2).setResizable(false);
        tabela_itens.getColumnModel().getColumn(3).setResizable(false);
        tabela_itens.getColumnModel().getColumn(4).setResizable(false);
        
        for(int i = 0; i < dadosRecibos.size(); i++){
            br = new BeanRecibos();
            if(dadosRecibos.get(i).get(0)  != null){br.idRecibo         = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(0)));}
            if(dadosRecibos.get(i).get(1)  != null){br.idEmpresa        = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(1)));}
            if(dadosRecibos.get(i).get(2)  != null){br.codigoGrupo      = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(2)));}
            if(dadosRecibos.get(i).get(3)  != null){br.codigoEmpresa    = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(3)));}
            if(dadosRecibos.get(i).get(4)  != null){br.codigoRecibo     = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(4)));}
            if(dadosRecibos.get(i).get(5)  != null){br.codigoCliente    = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(5)));}
            if(dadosRecibos.get(i).get(6)  != null){br.codigoUsuario    = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(6)));}
            if(dadosRecibos.get(i).get(7)  != null){br.dataRecibo       =                    String.valueOf(dadosRecibos.get(i).get(7));}
            if(dadosRecibos.get(i).get(8)  != null){br.horaRecibo       =                    String.valueOf(dadosRecibos.get(i).get(8));}
            if(dadosRecibos.get(i).get(9)  != null){br.status           = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(9)));}
            if(dadosRecibos.get(i).get(10) != null){br.observacoes      =                    String.valueOf(dadosRecibos.get(i).get(10));}
            if(dadosRecibos.get(i).get(11) != null){br.ocorrenciaRecibo = Integer.parseInt(  String.valueOf(dadosRecibos.get(i).get(11)));}
            if(dadosRecibos.get(i).get(12) != null){br.dataEmissaoLote  =                    String.valueOf(dadosRecibos.get(i).get(12));}
            
            bc.codigoCliente    = br.codigoCliente;
            txt_codigoCliente.setText(String.valueOf(bc.codigoCliente));
            PegaCliente();
            
            brd.idEmpresa        = br.idEmpresa;
            brd.codigoGrupo      = br.codigoGrupo;
            brd.codigoEmpresa    = br.codigoEmpresa;
            brd.codigoRecibo     = br.codigoRecibo;
            PegaReciboDetalhes();
        }
        operacao = "A";
        if(br.status == 1 || br.status == 3){
            operacao = "";
            combo_Pagamento .setEnabled(false);
            combo_Pagamento .setFocusable(false);
            txt_valor       .setEditable(false);
            txt_valor       .setFocusable(false);
        }
        if(!somostra.equalsIgnoreCase("N"))TableItens.addRow(new Object[] {"", "TOTAIS", "", "", TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorTotalItens), 0)});
    }
    
    private void PegaReciboDetalhes(){
        sql = "select * from tb_recibos_detalhes where idEmpresa = " + brd.idEmpresa + " and codigoRecibo = " + brd.codigoRecibo + ";";
        dadosRecibosDetalhes.clear();
        dadosRecibosDetalhes = parametrosNS.dao.Consulta(sql);
        if(dadosRecibosDetalhes.isEmpty()){
//            mensagem = "Não foram encontrados itens para o recibo n°" + br.codigoRecibo + ";";
//            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosReciboDetalhes();
    }
    
    private void PegaDadosReciboDetalhes(){
        ValorTotalItens     = 0;
        TableItens.setNumRows(0);
        QtdItensPagos       = 0;
        if(br.status > 0)PegaReciboPagamentos();
        for(int i = 0; i < dadosRecibosDetalhes.size(); i++){
            brd = new BeanRecibosDetalhes();
            brd.idReciboDetalhes        = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(0)));
            brd.idEmpresa               = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(1)));
            brd.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(2)));
            brd.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(3)));
            brd.codigoRecibo            = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(4)));
            brd.codigoReciboItem        = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(5)));
            brd.codigoServico           = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(6)));
            brd.valorServico            = Double.parseDouble(String.valueOf(dadosRecibosDetalhes.get(i).get(7)));
            brd.quantidade              = Integer.parseInt(  String.valueOf(dadosRecibosDetalhes.get(i).get(8)));
            brd.valorTotal              = Double.parseDouble(String.valueOf(dadosRecibosDetalhes.get(i).get(9)));
            
            ValorTotalItens            += brd.valorTotal;
            
            if(ValorTotalItens <= ValorTotalPago){
                QtdItensPagos++;
            }
            
            bser.codigoServico          = brd.codigoServico;
            PegaServicos();
            
            TableItens.addRow(new Object[] {fc.FormataCampo(String.valueOf(brd.codigoReciboItem), 2, 0), fc.FormataCampo(String.valueOf(brd.codigoServico), 6, 0) + "-" + bser.descricaoServico, TransStrDou.TransformaValorStringeDouble(String.valueOf(brd.valorServico), 0), brd.quantidade, TransStrDou.TransformaValorStringeDouble(String.valueOf(brd.valorTotal), 0)});
        }
        if(br.status == 1){return;}
        if(br.status == 3){return;}
        ValorTotal          = ValorTotalPago - ValorTotalItens;
        if(ValorTotal < 0){
            ValorTotal  *= (-1);
        }
        bt_imprimir.setEnabled(true);
        ValorRestante       = ValorTotal;
        txt_valor           .setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorRestante), 0));
        txt_valorRestante   .setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorRestante), 0));
        txt_valorAPagar     .setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorRestante), 0));
        
        txt_codigoServico .setText("");
        label_descricao   .setText("");
        txt_valorUnitario .setText("");
        txt_quantidade    .setText("");
        txt_valorTotal    .setText("");
        bt_adicionaServico.setEnabled  (false);
        bt_adicionaServico.setFocusable(false);
        txt_codigoServico .grabFocus();
    }
    
    private void PegaReciboPagamentos(){
        brp.idEmpresa        = br.idEmpresa;
        brp.codigoGrupo      = br.codigoGrupo;
        brp.codigoEmpresa    = br.codigoEmpresa;
        brp.codigoRecibo     = br.codigoRecibo;
        sql = "select * from tb_recibos_pagamentos where idEmpresa = " + brp.idEmpresa + " and codigoRecibo = " + brp.codigoRecibo + ";";
        dadosRecibosPagamentos.clear();
        dadosRecibosPagamentos = parametrosNS.dao.Consulta(sql);
        if(dadosRecibosPagamentos.isEmpty()){
            mensagem = "Não foram encontrados pagamentos para o Recibo n°" + br.codigoRecibo + "!";
            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosReciboPagamentos();
    }
    
    private void PegaDadosReciboPagamentos(){
        TablePagamento.setNumRows(0);
        ValorTotalPago  = 0;
        for(int i = 0; i < dadosRecibosPagamentos.size(); i++){
            brp = new BeanRecibosPagamentos();
            if(dadosRecibosPagamentos.get(i).get(0) != null){brp.idRecibosPagamento  = Integer.parseInt(  String.valueOf(dadosRecibosPagamentos.get(i).get(0)));}
            if(dadosRecibosPagamentos.get(i).get(1) != null){brp.idEmpresa           = Integer.parseInt(  String.valueOf(dadosRecibosPagamentos.get(i).get(1)));}
            if(dadosRecibosPagamentos.get(i).get(2) != null){brp.codigoGrupo         = Integer.parseInt(  String.valueOf(dadosRecibosPagamentos.get(i).get(2)));}
            if(dadosRecibosPagamentos.get(i).get(3) != null){brp.codigoEmpresa       = Integer.parseInt(  String.valueOf(dadosRecibosPagamentos.get(i).get(3)));}
            if(dadosRecibosPagamentos.get(i).get(4) != null){brp.codigoRecibo        = Integer.parseInt(  String.valueOf(dadosRecibosPagamentos.get(i).get(4)));}
            if(dadosRecibosPagamentos.get(i).get(5) != null){brp.codigoPagamento     = Integer.parseInt(  String.valueOf(dadosRecibosPagamentos.get(i).get(5)));}
            if(dadosRecibosPagamentos.get(i).get(6) != null){brp.valorDoPagamento    = Double.parseDouble(String.valueOf(dadosRecibosPagamentos.get(i).get(6)));}
            if(dadosRecibosPagamentos.get(i).get(7) != null){brp.trocoDoPagamento    = Double.parseDouble(String.valueOf(dadosRecibosPagamentos.get(i).get(7)));}
            
            ValorTotalPago             += brp.valorDoPagamento - brp.trocoDoPagamento;
            
            bfp.codigoPagamento         = brp.codigoPagamento;
            PegaFormasDePagamentos("N");
            
            TablePagamento.addRow(new Object[] {fc.FormataCampo(String.valueOf(brp.codigoPagamento), 2, 0) + "-" + bfp.descricaoPagamento, TransStrDou.TransformaValorStringeDouble(String.valueOf(brp.valorDoPagamento), 0), TransStrDou.TransformaValorStringeDouble(String.valueOf(brp.trocoDoPagamento), 0)});
        }
    }
    
    private void PagamentosRecibos(){
        if(brp.trocoDoPagamento >= 0.01){
            mensagem = "Valor Pago já bateu com Valor a Pagar!";
            new MostraMensagem(mensagem);
            return;
        }
        brp.idEmpresa       = br.idEmpresa;
        brp.codigoGrupo     = br.codigoGrupo;
        brp.codigoEmpresa   = br.codigoEmpresa;
        brp.codigoRecibo    = br.codigoRecibo;
        brp.codigoPagamento     = Integer.parseInt(String.valueOf(combo_Pagamento.getSelectedItem()).substring(0, 2));
        bfp.descricaoPagamento  = String.valueOf(combo_Pagamento.getSelectedItem());
        brp.valorDoPagamento    = Double.parseDouble(txt_valor.getText());
        if(brp.valorDoPagamento == 0){
            mensagem = "Valor do Pagamento não pode ser Zero!";
            new MostraMensagem(mensagem);
            return;
        }
        ValorRestante          -= brp.valorDoPagamento;
        if(ValorRestante <= 0){
            if(ValorRestante < 0){
                brp.trocoDoPagamento    = ValorRestante * (-1);
            }
            ValorRestante   = 0;
            bt_finalizar.setEnabled(true);
            bt_finalizar.grabFocus();
        }else{
            bt_finalizar.setEnabled(false);
            combo_Pagamento.grabFocus();
        }
        txt_valor.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorRestante), 0));
        txt_valorRestante.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(ValorRestante), 0));
        TablePagamento.addRow(new Object[] {bfp.descricaoPagamento, TransStrDou.TransformaValorStringeDouble(String.valueOf(brp.valorDoPagamento), 0), TransStrDou.TransformaValorStringeDouble(String.valueOf(brp.trocoDoPagamento), 0)});
    }
    
    private void FinalizarRecibo(){
        if(Long.parseLong(bc.cpfCnpj.replace(" ", "")) == 0){
            if(JOptionPane.showConfirmDialog(null, "CPF na nota?") == JOptionPane.YES_OPTION){
                CpfNaNota = "S";
                txt_cpfcnpj1.setEditable(true);
                txt_cpfcnpj2.setEditable(true);
                txt_cpfcnpj3.setEditable(true);
                txt_cpfcnpj1.grabFocus();
                return;
            }
        }
        br.codigoRecibo         = Integer.parseInt(txt_codigoRecibo.getText());
        Confirmacao = JOptionPane.showConfirmDialog(null, "Deseja finalizar o recibo n°" + br.codigoRecibo + "?", "", JOptionPane.YES_NO_OPTION);
        if(Confirmacao != 0)
            return;
        br.codigoRecibo         = Integer.parseInt(txt_codigoRecibo.getText());
        sql = "update tb_recibos set status = 2 where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoRecibo = " + br.codigoRecibo + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        PegaDadosPagamentoRecibos();
        if(!sqlstate.equals("00000"))
            return;
        mensagem = "Recibo n°" + br.codigoRecibo + " finalizado com êxito!";
        new MostraMensagem(mensagem);
        ImprimirRecibo();
    }
    
    private void IncluirRecibo(){
        if(txt_codigoCliente.getText().replace(" ", "").equals("")){
            mensagem = "Cliente Inválido!";
            fatal = "S";
            new MostraMensagem(mensagem);
            return;
        }
        br.idEmpresa                = parametrosNS.be.IdEmpresa;
        br.codigoGrupo              = parametrosNS.bge.CodigoGrupo;
        br.codigoEmpresa            = parametrosNS.be.CodigoEmpresa;
        br.codigoRecibo             = Integer.parseInt(txt_codigoRecibo.getText());
        br.codigoCliente            = Integer.parseInt(txt_codigoCliente.getText());
        br.codigoUsuario            = parametrosNS.bu.codigoUsuario;
        br.dataRecibo               = invdata.inverterData(cdh.CapturarData(), 2);
        br.horaRecibo               = cdh.CapturaHora();
        br.status                   = 0;
        br.observacoes              = txt_observacoes.getText();
        
        sql = "insert into tb_recibos (idEmpresa, codigoGrupo, codigoEmpresa, codigoRecibo, codigoCliente, codigoUsuario, dataRecibo, horaRecibo, status, observacoes) "
            + "values (" + br.idEmpresa + ", " + br.codigoGrupo + ", " + br.codigoEmpresa + ", " + br.codigoRecibo + ", " + br.codigoCliente + ", " + br.codigoUsuario + ", '" + br.dataRecibo + "', '" + br.horaRecibo + "', " + br.status + ", '" + br.observacoes + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir Recibo n°" + br.codigoRecibo + "!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        operacao = "A";
    }
    
    private void IncluirReciboDetalhes(){
        brd.idEmpresa           = br.idEmpresa;
        brd.codigoGrupo         = br.codigoGrupo;
        brd.codigoEmpresa       = br.codigoEmpresa;
        brd.codigoRecibo        = br.codigoRecibo;
        sql = "select count(*) from tb_recibos_detalhes where idEmpresa = " + brd.idEmpresa + " and codigoRecibo = " + brd.codigoRecibo + ";";
        dadosCount.clear();
        dadosCount = parametrosNS.dao.Consulta(sql);
        brd.codigoReciboItem    = Integer.parseInt(  String.valueOf(dadosCount.get(0).get(0))) + 1;
        brd.codigoServico       = Integer.parseInt(txt_codigoServico.getText());
        brd.valorServico        = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorUnitario.getText(), 1));
        brd.quantidade          = Integer.parseInt(txt_quantidade.getText());
        brd.valorTotal          = brd.valorServico * brd.quantidade;
        
        sql = "insert into tb_recibos_detalhes (idEmpresa, codigoGrupo, codigoEmpresa, codigoRecibo, codigoReciboItem, codigoServico, valorServico, quantidade, valorTotal) "
            + "values (" + brd.idEmpresa + ", " + brd.codigoGrupo + ", " + brd.codigoEmpresa + ", " + brd.codigoRecibo + ", " + brd.codigoReciboItem + ", " + brd.codigoServico + ", " + brd.valorServico + ", " + brd.quantidade + ", " + brd.valorTotal + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir item n°" + brd.codigoReciboItem + " do recibo n°" + br.codigoRecibo + "!";
            new MostraMensagem(mensagem);
            return;
        }
        PegaReciboDetalhes();
    }
    
    private void PegaDadosPagamentoRecibos(){
        brp.idEmpresa       = br.idEmpresa;
        brp.codigoGrupo     = br.codigoGrupo;
        brp.codigoEmpresa   = br.codigoEmpresa;
        brp.codigoRecibo    = br.codigoRecibo;
        for(int i = dadosRecibosPagamentos.size(); i < tabela_pagamento.getRowCount(); i++){
            brp.codigoPagamento     = Integer.parseInt(String.valueOf(tabela_pagamento.getValueAt(i, 0)).substring(0, 2));
            brp.valorDoPagamento    = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_pagamento.getValueAt(i, 1)), 1));
            brp.trocoDoPagamento    = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(String.valueOf(tabela_pagamento.getValueAt(i, 2)), 1));
            
            sql = "insert into tb_recibos_pagamentos (idEmpresa, codigoGrupo, codigoEmpresa, codigoRecibo, codigoPagamento, valorDoPagamento, trocoDoPagamento) "
                + "values (" + brp.idEmpresa + ", " + brp.codigoGrupo + ", " + brp.codigoEmpresa + ", " + brp.codigoRecibo + ", " + brp.codigoPagamento + ", " + brp.valorDoPagamento + ", " + brp.trocoDoPagamento + ");";
            sqlstate = parametrosNS.dao.incluirRegistro(sql);
            if(!sqlstate.equals("00000")){
                mensagem = "Erro ao incluir pagamento " + brp.codigoPagamento + " do valor " + TransStrDou.TransformaValorStringeDouble(String.valueOf(brp.valorDoPagamento), 0) + "!";
                new MostraMensagem(mensagem);
                return;
            }
        }
    }
    
    private void ImprimirRecibo(){
        br.codigoRecibo = Integer.parseInt(txt_codigoRecibo.getText().replace(" ", ""));
        try{
            if(parametrosNS.be.imagemLogotipoEmpresa != null){
                BuffImg = ImageIO.read(new ByteArrayInputStream(parametrosNS.be.imagemLogotipoEmpresa));
                ImgIcon = new ImageIcon(BuffImg);
                Img     = ImgIcon.getImage();
            }
            
            hm.put("idEmpresa"      , br.idEmpresa);
            hm.put("codigoRecibo"   , br.codigoRecibo);
            hm.put("nomeEmpresa"    , parametrosNS.be.nomeEmpresa);
            hm.put("cnpjEmpresa"    , parametrosNS.be.cnpjEmpresa);
            hm.put("cidadeEmpresa"  , parametrosNS.be.cidadeEmpresa + ", " + parametrosNS.be.ufEmpresa);
            hm.put("enderecoEmpresa", parametrosNS.be.enderecoEmpresa + ", " + parametrosNS.be.numeroEmpresa + ", " + parametrosNS.be.bairroEmpresa);
            hm.put("cepEmpresa"     , parametrosNS.be.cepEmpresa);
            hm.put("telefoneEmpresa", parametrosNS.be.telefoneEmpresa);
            
            if(parametrosNS.be.imagemLogotipoEmpresa != null)
                hm.put("logotipoEmpresa", Img);
            else
                hm.put("logotipoEmpresa", null);
            
            jpv     = bpar.pastaRelatorios + "/Recibo.jasper";
            
            jpp     = JasperFillManager.fillReport(jpv, hm, parametrosNS.con);
            JasperViewer.viewReport(jpp, false);
        }catch(Exception erro){
            mensagem = "Erro ao imprimir: " + erro.getMessage();
            mostraMensagem();
        }
    }
    
    private void LimparTabelaDeItens(){
        brd.idEmpresa       = br.idEmpresa;
        brd.codigoGrupo     = br.codigoGrupo;
        brd.codigoEmpresa   = br.codigoEmpresa;
        brd.codigoRecibo    = br.codigoRecibo;
//        brd.codigoRecibo    = Integer.parseInt(txt_codigoRecibo.getText());
        if(JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir todos os itens do recibo n°" + brd.codigoRecibo + "?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
            return;
        sql = "delete from tb_recibos_detalhes where idEmpresa = " + brd.idEmpresa + " and codigoRecibo = " + brd.codigoRecibo + ";";
        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            return;
        }
        PegaRecibos();
    }
    
    private void RemoverItem(){
        if(Linha < 0){
            mensagem = "Item não Selecionado!";
            new MostraMensagem(mensagem);
            return;
        }
        brd.idEmpresa        = br.idEmpresa;
        brd.codigoGrupo      = br.codigoGrupo;
        brd.codigoEmpresa    = br.codigoEmpresa;
        brd.codigoRecibo     = br.codigoRecibo;
        brd.codigoReciboItem = Integer.parseInt(String.valueOf(tabela_itens.getValueAt(Linha, 0)));
        
        sql = "delete from tb_recibos_detalhes where idEmpresa = " + brd.idEmpresa + " and codigoRecibo = " + brd.codigoRecibo + " and codigoReciboItem = " + brd.codigoReciboItem + ";";
        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        int codigoReciboItem        = 0;
        for(int i = Linha; i < tabela_itens.getRowCount(); i++){
            brd.codigoReciboItem    = Integer.parseInt(String.valueOf(tabela_itens.getValueAt(i, 0)));
            codigoReciboItem        = brd.codigoReciboItem + 1;
            
            sql = "update tb_recibos_detalhes set codigoReciboItem = " + brd.codigoReciboItem + " where idEmpresa = " + brd.idEmpresa + " and codigoRecibo = " + brd.codigoRecibo + " and codigoReciboItem = " + codigoReciboItem + ";";
            sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        }
        PegaRecibos();
    }
    
}
