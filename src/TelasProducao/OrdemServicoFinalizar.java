package TelasProducao;

import FuncoesInternas.InverterData;
import Beans.*;
import FuncoesInternas.*;
import TelasContasCorrente.GerarBoletoBradesco;
import TelasContasCorrente.GerarBoletoItau;
import TelasContasCorrente.GerarBoletoSantander;
import Parametros.parametrosNS;
import java.sql.*;
import java.util.*;
import java.text.*;
/*
 @author Tiago e Paulo
 */
public class OrdemServicoFinalizar extends javax.swing.JFrame {
    //Connection
    Connection con;
    
    //String's
    String Mensagem                         = "";
    String sql                              = "";
    String sqlstate                         = "";
    String retorno                          = "";
    String fatal                            = "N";
    String operacao                         = "";
    
    //int's
    int    FinalizaOrdemServico             = 0;
    int    FaturarOrdemServico              = 0;
    int    FinalizaOrdemServicoSemSolucao   = 0;
    
    //double's
    double valorTotal                       = 0;
    double valorPagar                       = 0;
    
    //Vetores
    ArrayList            parametros                    = new ArrayList();
    ArrayList            dadosPadroes                  = new ArrayList();
    ArrayList<ArrayList> dadosCliente                  = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosSituacoes                = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosOrdemServico             = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosOrdemServicoItens        = new ArrayList<ArrayList>();
    
    //Beans's
    BeanClientes            bc              = new BeanClientes();
    BeanSituacoes           bsit            = new BeanSituacoes();
    BeanOrdemServico        bos             = new BeanOrdemServico();
    BeanOrdemServicoItens   bosi            = new BeanOrdemServicoItens();
    
    //Especiais
    FormataCampo                    fc           = new FormataCampo();
    FormataCampoCpfCnpj             FCampopfCnpj = new FormataCampoCpfCnpj();
    InverterData                    invdata      = new InverterData();
    TransformaValorStringeDouble    TransStrDou  = new TransformaValorStringeDouble();
    
    //Telas
    EfetuarPagamento                EfePag;
    OrdemServicoSemSolucaoCadastro  OrdSerSemSolCad;
    GerarBoletoItau                 GerBolItau;
    GerarBoletoSantander            GerBolSant;
    GerarBoletoBradesco             GerBolBrad;
    
    public OrdemServicoFinalizar(int IdOrdemServico){
        bos.idOrdemServico  = IdOrdemServico;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        jMenuPopup = new javax.swing.JMenu();
        bt_boletoitau = new javax.swing.JMenuItem();
        bt_boletohsbc = new javax.swing.JMenuItem();
        bt_boletosantander = new javax.swing.JMenuItem();
        bt_boletobradesco = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_codigoCliente = new javax.swing.JFormattedTextField();
        label_nomeCliente = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoOrdemServico = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txt_cpfcnpj1 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj2 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj3 = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_descricao = new javax.swing.JTextField();
        txt_defeito = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_situacao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_dataSaida = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_laudo = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_valorAdiantamento = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_valorTotal = new javax.swing.JTextField();
        txt_valorAPagar = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        bt_efetuarPagamento = new javax.swing.JButton();
        bt_faturar = new javax.swing.JButton();
        bt_semSolucao = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair = new javax.swing.JMenuItem();

        jMenuPopup.setText("Gerar boleto");

        bt_boletoitau.setText("Itaú (Cart. 109)");
        bt_boletoitau.setToolTipText("");
        bt_boletoitau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_boletoitauActionPerformed(evt);
            }
        });
        jMenuPopup.add(bt_boletoitau);

        bt_boletohsbc.setText("Hsbc");
        bt_boletohsbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_boletohsbcActionPerformed(evt);
            }
        });
        jMenuPopup.add(bt_boletohsbc);

        bt_boletosantander.setText("Santander");
        bt_boletosantander.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_boletosantanderActionPerformed(evt);
            }
        });
        jMenuPopup.add(bt_boletosantander);

        bt_boletobradesco.setText("Bradesco");
        bt_boletobradesco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_boletobradescoActionPerformed(evt);
            }
        });
        jMenuPopup.add(bt_boletobradesco);

        MenuPopup.add(jMenuPopup);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Finalizar Ordem de Servico");
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

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cliente");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoCliente.setEditable(false);
        txt_codigoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoClienteFocusLost(evt);
            }
        });
        txt_codigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_nomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_codigoCliente)
                    .addComponent(label_nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Código");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoOrdemServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoOrdemServico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoOrdemServico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoOrdemServicoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoOrdemServicoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_codigoOrdemServico, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_codigoOrdemServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("CPF ou CNPJ");
        jLabel35.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_cpfcnpj1.setEditable(false);
        try{
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
        try{
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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_cpfcnpj1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cpfcnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cpfcnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cpfcnpj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpfcnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpfcnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Descrição do Serviço/Equipamento");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Descrição: ");

        txt_descricao.setEditable(false);
        txt_descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descricaoActionPerformed(evt);
            }
        });

        txt_defeito.setEditable(false);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Defeito: ");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Situação: ");

        txt_situacao.setEditable(false);
        txt_situacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_situacaoActionPerformed(evt);
            }
        });

        jLabel1.setText("Data de Saída:");

        txt_dataSaida.setEditable(false);
        txt_dataSaida.setText("00/00/0000");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22))
                    .addComponent(txt_situacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_dataSaida))
                    .addComponent(txt_defeito))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_defeito, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txt_dataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel22, jLabel4, jLabel5, txt_dataSaida, txt_defeito, txt_descricao, txt_situacao});

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Laudo Técnico");
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_laudo.setEditable(false);
        txt_laudo.setColumns(20);
        txt_laudo.setRows(5);
        txt_laudo.setEnabled(false);
        jScrollPane1.setViewportView(txt_laudo);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Valores: ");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Adiantamento: ");

        txt_valorAdiantamento.setEditable(false);
        txt_valorAdiantamento.setText("R$ 0,00");
        txt_valorAdiantamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorAdiantamentoFocusLost(evt);
            }
        });
        txt_valorAdiantamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valorAdiantamentoActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Valor Total: ");

        txt_valorTotal.setEditable(false);
        txt_valorTotal.setText("R$ 0,00");
        txt_valorTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorTotalFocusLost(evt);
            }
        });

        txt_valorAPagar.setEditable(false);
        txt_valorAPagar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_valorAPagar.setText("R$ 0,00");
        txt_valorAPagar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorAPagarFocusLost(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setText("Valor a pagar: ");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_valorAdiantamento, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_valorAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txt_valorAdiantamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txt_valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_valorAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel19, jLabel25, txt_valorAdiantamento, txt_valorTotal});

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel20, txt_valorAPagar});

        bt_efetuarPagamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_efetuarPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/vend.png"))); // NOI18N
        bt_efetuarPagamento.setText("Efetuar Pagamento");
        bt_efetuarPagamento.setEnabled(false);
        bt_efetuarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_efetuarPagamentoActionPerformed(evt);
            }
        });

        bt_faturar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_faturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/RelatVend.png"))); // NOI18N
        bt_faturar.setText("Faturar / Cobrança");
        bt_faturar.setEnabled(false);
        bt_faturar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_faturarMouseClicked(evt);
            }
        });
        bt_faturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_faturarActionPerformed(evt);
            }
        });

        bt_semSolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/No.png"))); // NOI18N
        bt_semSolucao.setText("OS Sem Solução");
        bt_semSolucao.setEnabled(false);
        bt_semSolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_semSolucaoActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        bt_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_efetuarPagamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_faturar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_semSolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_efetuarPagamento, bt_faturar, bt_semSolucao});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_efetuarPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_faturar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_semSolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_efetuarPagamento, bt_faturar, bt_semSolucao});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoClienteActionPerformed

    private void txt_codigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFocusLost
        if(txt_codigoOrdemServico.isEditable() == false)
            return;
        if(txt_codigoOrdemServico.getText().replace(" ", "").equals(""))
            return;
        PegaCliente();
    }//GEN-LAST:event_txt_codigoClienteFocusLost

    private void txt_codigoOrdemServicoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrdemServicoFocusGained
        if(txt_codigoOrdemServico.isEditable() == false)
            return;
        txt_codigoOrdemServico.setText("");
        ReiniciaCampos();
    }//GEN-LAST:event_txt_codigoOrdemServicoFocusGained

    private void txt_codigoOrdemServicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrdemServicoFocusLost
        if(txt_codigoOrdemServico.isEditable() == false)
            return;
        if(txt_codigoOrdemServico.getText().replace(" ", "").equals(""))
            return;
        bos.codigoOrdemServico = Integer.parseInt(txt_codigoOrdemServico.getText().replace(" ", ""));
        if(bos.codigoOrdemServico == 0)
            return;
        sql = "select \n"
            + "   idOrdemServico, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoOrdemServico, \n"
            + "   codigoCliente, \n"
            + "   codigoUsuario, \n"
            + "   dataSaida, \n"
            + "   horaSaida, \n"
            + "   codigoSituacao, \n"
            + "   valorAdiantamento, \n"
            + "   valorDeslocamento, \n"
            + "   valorTerceiros, \n"
            + "   valorOutros, \n"
            + "   descricao, \n"
            + "   defeito, \n"
            + "   laudo \n"
            + "from \n"
            + "   tb_os where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoOrdemServico = " + bos.codigoOrdemServico + ";";
        PegaOrdemServico();
    }//GEN-LAST:event_txt_codigoOrdemServicoFocusLost

    private void txt_cpfcnpj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfcnpj1ActionPerformed

    private void txt_cpfcnpj1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1FocusGained
        
    }//GEN-LAST:event_txt_cpfcnpj1FocusGained

    private void txt_cpfcnpj1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1FocusLost

    }//GEN-LAST:event_txt_cpfcnpj1FocusLost

    private void txt_cpfcnpj1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfcnpj1KeyReleased

    private void txt_cpfcnpj2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj2FocusLost

    }//GEN-LAST:event_txt_cpfcnpj2FocusLost

    private void txt_cpfcnpj2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfcnpj2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfcnpj2ActionPerformed

    private void txt_cpfcnpj3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj3FocusLost

    }//GEN-LAST:event_txt_cpfcnpj3FocusLost

    private void txt_cpfcnpj3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfcnpj3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfcnpj3ActionPerformed

    private void txt_descricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descricaoActionPerformed

    private void txt_situacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_situacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_situacaoActionPerformed

    private void txt_valorAdiantamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorAdiantamentoFocusLost
        
    }//GEN-LAST:event_txt_valorAdiantamentoFocusLost

    private void txt_valorAdiantamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_valorAdiantamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valorAdiantamentoActionPerformed

    private void txt_valorTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorTotalFocusLost
        
    }//GEN-LAST:event_txt_valorTotalFocusLost

    private void txt_valorAPagarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorAPagarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valorAPagarFocusLost

    private void bt_efetuarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_efetuarPagamentoActionPerformed
        if(EfePag != null)if(EfePag.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        FinalizaOrdemServico = 1;
        parametros.clear();
        parametros.add(bos.idOrdemServico);
        parametros.add(0);
        parametros.add(0);
        parametros.add(0);
        parametros.add("OS");
        EfePag = new EfetuarPagamento(parametros, null);
        EfePag.setVisible(true);
    }//GEN-LAST:event_bt_efetuarPagamentoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(FinalizaOrdemServico == 0){
            AbreFinalizarSemSolucao();
            return;
        }
        FinalizaOrdemServico = 0;
        sqlstate = EfePag.getRetornoFinaliza();
        if(!sqlstate.equals("00000"))
            return;
        dispose();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbreFinalizarSemSolucao(){
        if(FinalizaOrdemServicoSemSolucao == 0){
            AbreFaturarOrdemServico();
            return;
        }
        FinalizaOrdemServicoSemSolucao = 0;
        sqlstate = OrdSerSemSolCad.getRetornoFinalizaOrdemServicoSemSolucao();
        if(!sqlstate.equals("ok"))
            return;
        dispose();
    }
    
    private void AbreFaturarOrdemServico(){
        if(FaturarOrdemServico == 0)
            return;
        FaturarOrdemServico = 0;
        sqlstate = GerBolItau.getRetorno();
        if(!sqlstate.equals("ok"))
            return;
        bos.dataFinalizou       = parametrosNS.invdata.inverterData(parametrosNS.cdh.CapturarData(), 2);
        bos.horaFinalizou       = parametrosNS.cdh.CapturaHora();
        bos.usuarioFinalizou    = parametrosNS.bu.codigoUsuario;
        bos.idEmpresaFinalizou  = parametrosNS.be.IdEmpresa;
        bos.computadorFinalizou = parametrosNS.bcomp.codigoComputador;
        sql = "update tb_os set statusOs = 4, " +
                               "dataFinalizou = '"      + bos.dataFinalizou         + "', " +
                               "horaFinalizou = '"      + bos.horaFinalizou         + "', " +
                               "usuarioFinalizou = "    + bos.usuarioFinalizou      + ", " +
                               "idEmpresaFinalizou = "  + bos.idEmpresaFinalizou    + ", " +
                               "computadorFinalizou = " + bos.computadorFinalizou   + " " +
                               "where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoOrdemServico = " + bos.codigoOrdemServico + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        retorno = "ok";
        dispose();
    }
    
    private void bt_semSolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_semSolucaoActionPerformed
        if(OrdSerSemSolCad != null)if(OrdSerSemSolCad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        FinalizaOrdemServicoSemSolucao = 1;
        OrdSerSemSolCad = new OrdemServicoSemSolucaoCadastro(bos.idOrdemServico);
        OrdSerSemSolCad.setVisible(true);
    }//GEN-LAST:event_bt_semSolucaoActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(bos.idOrdemServico != 0){
            txt_codigoOrdemServico.setEditable(false);
            sql = "select \n"
            + "   idOrdemServico, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoOrdemServico, \n"
            + "   codigoCliente, \n"
            + "   codigoUsuario, \n"
            + "   dataSaida, \n"
            + "   horaSaida, \n"
            + "   codigoSituacao, \n"
            + "   valorAdiantamento, \n"
            + "   valorDeslocamento, \n"
            + "   valorTerceiros, \n"
            + "   valorOutros, \n"
            + "   descricao, \n"
            + "   defeito, \n"
            + "   laudo \n"
            + "from \n"
            + "   tb_os where idOrdemServico = " + bos.idOrdemServico + ";";
            PegaOrdemServico();
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(EfePag           != null)EfePag          .dispose();
        if(OrdSerSemSolCad  != null)OrdSerSemSolCad .dispose();
        if(GerBolItau       != null)GerBolItau      .dispose();
    }//GEN-LAST:event_formWindowClosed

    private void bt_faturarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_faturarMouseClicked
        MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_bt_faturarMouseClicked

    private void bt_boletoitauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_boletoitauActionPerformed
        if(GerBolItau != null)if(GerBolItau.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        FaturarOrdemServico = 1;
        parametros.clear();
        parametros.add("SN");
        parametros.add(0);
        parametros.add(Integer.parseInt(txt_codigoCliente.getText()));
        parametros.add("OS");
        parametros.add(Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorAPagar.getText(), 1)));
        GerBolItau = new GerarBoletoItau(parametros);
        GerBolItau.setVisible(true);
    }//GEN-LAST:event_bt_boletoitauActionPerformed

    private void bt_boletohsbcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_boletohsbcActionPerformed
        
    }//GEN-LAST:event_bt_boletohsbcActionPerformed

    private void bt_boletosantanderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_boletosantanderActionPerformed
        if(GerBolSant != null)if(GerBolSant.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        parametros.clear();
        parametros.add("SN");
        parametros.add(0);
        parametros.add(Integer.parseInt(txt_codigoCliente.getText()));
        parametros.add("OS");
        parametros.add(Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorAPagar.getText(), 1)));
        FaturarOrdemServico = 1;
        GerBolSant = new GerarBoletoSantander(parametros);
        GerBolSant.setVisible(true);
    }//GEN-LAST:event_bt_boletosantanderActionPerformed

    private void bt_boletobradescoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_boletobradescoActionPerformed
        if(GerBolBrad != null)if(GerBolBrad.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        FaturarOrdemServico = 1;
        parametros.clear();
        parametros.add("SN");
        parametros.add(0);
        parametros.add(Integer.parseInt(txt_codigoCliente.getText()));
        parametros.add("OS");
        parametros.add(Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorAPagar.getText(), 1)));
        GerBolBrad = new GerarBoletoBradesco(parametros);
        GerBolBrad.setVisible(true);
    }//GEN-LAST:event_bt_boletobradescoActionPerformed

    private void bt_faturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_faturarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_faturarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_boletobradesco;
    private javax.swing.JMenuItem bt_boletohsbc;
    private javax.swing.JMenuItem bt_boletoitau;
    private javax.swing.JMenuItem bt_boletosantander;
    private javax.swing.JButton bt_efetuarPagamento;
    private javax.swing.JButton bt_faturar;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JButton bt_semSolucao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuPopup;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_nomeCliente;
    private javax.swing.JFormattedTextField txt_codigoCliente;
    private javax.swing.JFormattedTextField txt_codigoOrdemServico;
    private javax.swing.JFormattedTextField txt_cpfcnpj1;
    private javax.swing.JFormattedTextField txt_cpfcnpj2;
    private javax.swing.JFormattedTextField txt_cpfcnpj3;
    private javax.swing.JTextField txt_dataSaida;
    private javax.swing.JTextField txt_defeito;
    private javax.swing.JTextField txt_descricao;
    private javax.swing.JTextArea txt_laudo;
    private javax.swing.JTextField txt_situacao;
    private javax.swing.JTextField txt_valorAPagar;
    private javax.swing.JTextField txt_valorAdiantamento;
    private javax.swing.JTextField txt_valorTotal;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
    private void PegaOrdemServico(){
        fatal = "N";
        dadosOrdemServico.clear();
        dadosOrdemServico = parametrosNS.dao.Consulta(sql);
        if(dadosOrdemServico.isEmpty()){
            Mensagem = "Ordem de Serviço " + bos.codigoOrdemServico + " não encontrada!\nPara incluir pressione Novo!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        PegaDadosOrdemServico();
    }
    
    private void PegaDadosOrdemServico(){
        for(int i = 0; i < dadosOrdemServico.size(); i++){
            bos     = new BeanOrdemServico();
        if(dadosOrdemServico.get(i).get(0) != null)
            bos.idOrdemServico          = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(0)));
        if(dadosOrdemServico.get(i).get(1) != null)
            bos.idEmpresa               = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(1)));
        if(dadosOrdemServico.get(i).get(2) != null)
            bos.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(2)));
        if(dadosOrdemServico.get(i).get(3) != null)
            bos.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(3)));
        if(dadosOrdemServico.get(i).get(4) != null)
            bos.codigoOrdemServico      = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(4)));
        if(dadosOrdemServico.get(i).get(5) != null)
            bos.codigoCliente           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(5)));
        if(dadosOrdemServico.get(i).get(6) != null)
            bos.codigoUsuario           = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(6)));
            bos.dataSaida               =                    String.valueOf(dadosOrdemServico.get(i).get(7));
            bos.horaSaida               =                    String.valueOf(dadosOrdemServico.get(i).get(8));
        if(dadosOrdemServico.get(i).get(9) != null)
            bos.codigoSituacao          = Integer.parseInt(  String.valueOf(dadosOrdemServico.get(i).get(9)));
        if(dadosOrdemServico.get(i).get(10) != null)
            bos.valorAdiantamento       = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(10)));
        if(dadosOrdemServico.get(i).get(11) != null)
            bos.valorDeslocamento       = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(11)));
        if(dadosOrdemServico.get(i).get(12) != null)
            bos.valorTerceiros          = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(12)));
        if(dadosOrdemServico.get(i).get(13) != null)
            bos.valorOutros             = Double.parseDouble(String.valueOf(dadosOrdemServico.get(i).get(13)));
            bos.descricao               =                    String.valueOf(dadosOrdemServico.get(i).get(14));
            bos.defeito                 =                    String.valueOf(dadosOrdemServico.get(i).get(15));
            bos.laudo                   =                    String.valueOf(dadosOrdemServico.get(i).get(16));
            
            bosi.idEmpresa          = bos.idEmpresa;
            bosi.codigoGrupo        = bos.codigoGrupo;
            bosi.codigoEmpresa      = bos.codigoEmpresa;
            bosi.codigoOrdemServico = bos.codigoOrdemServico;
            PegaItensOrdemServico();
            
            valorTotal  = bos.valorDeslocamento + bos.valorPecas + bos.valorMaoDeObra + bos.valorTerceiros + bos.valorOutros + bos.valorAdiantamento;
        }
        txt_codigoOrdemServico.setText(fc.FormataCampo(String.valueOf(bos.codigoOrdemServico), 9, 0));
        
        txt_codigoCliente.setText(String.valueOf(bos.codigoCliente));
        PegaCliente();
        
        txt_descricao.setText(bos.descricao);
        txt_defeito.setText(bos.defeito);
        
        bsit.codigoSituacao = bos.codigoSituacao;
        PegaSituacao();
        
        if(!bos.dataSaida.equals("null"))
            if(!bos.horaSaida.equals("null"))
                txt_dataSaida.setText(invdata.inverterData(bos.dataSaida, 1) + "   " + bos.horaSaida);
            else
                txt_dataSaida.setText(invdata.inverterData(bos.dataSaida, 1));
        
        txt_laudo.setText(bos.laudo);
        valorPagar = valorTotal - bos.valorAdiantamento;
        txt_valorAdiantamento.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bos.valorAdiantamento), 0));
        txt_valorTotal.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(valorTotal), 0));
        txt_valorAPagar.setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(valorPagar), 0));
        if(valorPagar <= 0){
            bt_efetuarPagamento .setEnabled(false);
            bt_faturar          .setEnabled(false);
            bt_semSolucao       .setEnabled(false);
            return;
        }
        bt_efetuarPagamento .setEnabled(true);
        bt_faturar          .setEnabled(true);
        bt_semSolucao       .setEnabled(true);
        
        bt_efetuarPagamento .grabFocus();
    }
    
    private void PegaItensOrdemServico(){
        sql = "select \n"
            + "   idOrdemServicoItem, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoOrdemServico, \n"
            + "   codigoOrdemServicoItem, \n"
            + "   codigoUsuario, \n"
            + "   valorUnitario, \n"
            + "   quantidade, \n"
            + "   valorTotal, \n"
            + "   codigoServico, \n"
            + "   codigoProduto \n"
            + "from tb_os_itens where idEmpresa = " + bosi.idEmpresa + " and codigoOrdemServico = " + bosi.codigoOrdemServico + ";";
        dadosOrdemServicoItens.clear();
        dadosOrdemServicoItens = parametrosNS.dao.Consulta(sql);
        if(dadosOrdemServicoItens.isEmpty()){
            Mensagem = "Não existem itens cadastrados para a OS " + bos.codigoOrdemServico + "!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosItensOrdemServico();
    }
    
    private void PegaDadosItensOrdemServico(){
        bos.valorPecas      = 0;
        bos.valorMaoDeObra  = 0;
        for(int i = 0; i < dadosOrdemServicoItens.size(); i++){
            bosi = new BeanOrdemServicoItens();
        if(dadosOrdemServicoItens.get(i).get(0)  != null){bosi.idOrdemServicoItem     = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(0)));}
        if(dadosOrdemServicoItens.get(i).get(1)  != null){bosi.idEmpresa              = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(1)));}
        if(dadosOrdemServicoItens.get(i).get(2)  != null){bosi.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(2)));}
        if(dadosOrdemServicoItens.get(i).get(3)  != null){bosi.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(3)));}
        if(dadosOrdemServicoItens.get(i).get(4)  != null){bosi.codigoOrdemServico     = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(4)));}
        if(dadosOrdemServicoItens.get(i).get(5)  != null){bosi.codigoOrdemServicoItem = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(5)));}
        if(dadosOrdemServicoItens.get(i).get(6)  != null){bosi.codigoUsuario          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(6)));}
        if(dadosOrdemServicoItens.get(i).get(7)  != null){bosi.valorUnitario          = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(7)));}
        if(dadosOrdemServicoItens.get(i).get(8)  != null){bosi.quantidade             = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(8)));}
        if(dadosOrdemServicoItens.get(i).get(9)  != null){bosi.valorTotal             = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(9)));}
        if(dadosOrdemServicoItens.get(i).get(10) != null){bosi.codigoServico          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(10)));}
        if(dadosOrdemServicoItens.get(i).get(11) != null){bosi.codigoProduto          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(11)));}
            
            if(bosi.codigoProduto != 0)
                bos.valorPecas      = bos.valorPecas        + bosi.valorTotal;
            if(bosi.codigoServico != 0)
                bos.valorMaoDeObra  = bos.valorMaoDeObra    + bosi.valorTotal;
        }
    }
    
    private void PegaCliente(){
        fatal = "N";
        txt_codigoCliente.setText(fc.FormataCampo(txt_codigoCliente.getText(), 5, 0));
        bc.codigoCliente = Integer.parseInt(txt_codigoCliente.getText());
        if(bc.codigoCliente == 0)
            return;
        sql = "select \n"
            + "   idCliente, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoCliente, \n"
            + "   nome, \n"
            + "   cpfCnpj \n"
            + "from \n"
            + "   tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = '" + bc.codigoCliente + "';";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            Mensagem = "Cliente " + bc.codigoCliente + " não encontrado!";
            new MostraMensagem(Mensagem);
            fatal = "S";
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
        label_nomeCliente.setText(bc.nome);
        bc.cpfCnpj  = FCampopfCnpj.FormataCampoCpfCnpj(bc.cpfCnpj);
        txt_cpfcnpj1.setText(bc.cpfCnpj.substring(0 , 9));
        txt_cpfcnpj2.setText(bc.cpfCnpj.substring(9 ,13));
        txt_cpfcnpj3.setText(bc.cpfCnpj.substring(13,15));
    }
    
    private void PegaSituacao(){
        sql = "select \n"
                + "idSituacao, \n"
                + "idEmpresa, \n"
                + "codigoGrupo, \n"
                + "codigoEmpresa, \n"
                + "codigoSituacao, \n"
                + "descricaoSituacao \n"
            + "from tb_situacoes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoSituacao = " + bsit.codigoSituacao + ";";
        dadosSituacoes.clear();
        dadosSituacoes = parametrosNS.dao.Consulta(sql);
        if(dadosSituacoes.isEmpty()){
//            Mensagem = "Situação número " + bos.codigoSituacao + " não encontrada!";
//            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosSituacao();
    }
    
    private void PegaDadosSituacao(){
        for(int i = 0; i <  dadosSituacoes.size(); i++){
            bsit.idSituacao         = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(0)));
            bsit.idEmpresa          = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(1)));
            bsit.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(2)));
            bsit.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(3)));
            bsit.codigoSituacao     = Integer.parseInt(  String.valueOf(dadosSituacoes.get(i).get(4)));
            bsit.descricaoSituacao  =                    String.valueOf(dadosSituacoes.get(i).get(5));
        }
        txt_situacao.setText(bsit.descricaoSituacao);
    }
    
    private void ReiniciaCampos(){
        txt_codigoCliente.setText("");
        label_nomeCliente.setText("");
        txt_cpfcnpj1.setText("");
        txt_cpfcnpj2.setText("");
        txt_cpfcnpj3.setText("");
        txt_descricao.setText("");
        txt_defeito.setText("");
        txt_situacao.setText("");
        txt_dataSaida.setText("");
        txt_laudo.setText("");
        txt_valorAdiantamento.setText("");
        txt_valorTotal.setText("");
        txt_valorAPagar.setText("");
        bt_efetuarPagamento.setEnabled(false);
        bt_faturar.setEnabled(false);
        bt_semSolucao.setEnabled(false);
    }
    
    public String getRetornoFinalizaOrdemServico(){
        return sqlstate;
    }
    
}
