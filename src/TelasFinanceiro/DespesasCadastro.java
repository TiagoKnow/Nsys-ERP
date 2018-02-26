package TelasFinanceiro;

import Beans.BeanDespesas;
import Beans.BeanDespesasTipo;
import Beans.BeanContaCorrente;
import Beans.BeanUsuarios;
import BeansNS.BeanBanco;
import BeansNS.BeanEmpresas;
import FuncoesInternas.CalculaDataDeVencimento;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.PegaProximoRegistro;
import FuncoesInternas.TestarData;
import FuncoesInternas.TransformaValorStringeDouble;
import FuncoesInternas.ValidarData;
import TelasContasCorrente.ContaCorrenteCadastro;
import TelasContasCorrente.ContaCorrenteConsulta;
import Parametros.parametrosNS;
import java.util.ArrayList;
/*
 @author Tiago e Paulo
 */
public class DespesasCadastro extends javax.swing.JFrame {
    //String
    String sql      = "";
    String fatal    = "";
    String mensagem = "";
    String sqlstate = "";
    String somostra = "";
    String operacao = "";
    String retorno  = "";
    String saida    = "";
    
    //int para laço for
    int i = 0;
    
    //int
    int abriuDespesa       = 0;
    int abriuDespesaTipo   = 0;
    int abriuContaCorrente = 0;
    int transferencias     = 0;
    
    //Vetores
    ArrayList            parametros         = new ArrayList();
    ArrayList            dadosPadroes       = new ArrayList();
    ArrayList<ArrayList> dadosBancos        = new ArrayList();
    ArrayList<ArrayList> dadosDespesas      = new ArrayList();
    ArrayList<ArrayList> dadosDespesasTipo  = new ArrayList();
    ArrayList<ArrayList> dadosContaCorrente = new ArrayList();
    ArrayList<ArrayList> dadosUsuarios      = new ArrayList();
    ArrayList<ArrayList> dadosEmpresas      = new ArrayList();
    
    //Bean
    BeanBanco         bb  = new BeanBanco();
    BeanDespesas      bd  = new BeanDespesas();
    BeanDespesasTipo  bdt = new BeanDespesasTipo();
    BeanContaCorrente bcc = new BeanContaCorrente();
    BeanEmpresas      be  = new BeanEmpresas();
    BeanUsuarios      bu  = new BeanUsuarios();
    
    //Funções
    FormataCampo                 fc          = new FormataCampo();
    InverterData                 invdata     = new InverterData();
    CapturarDataHora             cdh         = new CapturarDataHora();
    CalculaDataDeVencimento      CalVen      = new CalculaDataDeVencimento();
    TestarData                   Test        = new TestarData();
    ValidarData                  ValData     = new ValidarData();
    PegaProximoRegistro          PegProReg   = new PegaProximoRegistro();
    TransformaValorStringeDouble TransStrDou = new TransformaValorStringeDouble();
    
    //Telas
    DespesasConsulta            DesCon;
    ContaCorrenteCadastro       ConCorCad;
    ContaCorrenteConsulta       ConCorCon;
    DespesasTipoCadastro        DesTipoCad;
    DespesasTipoConsulta        DesTipoCon;
    
    public DespesasCadastro(String Somostra, int CodigoDespesa){
        somostra         = Somostra;
        bd.codigoDespesa = CodigoDespesa;
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigoDespesa = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_descricaoDespesa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_valorDespesa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_qtdMeses = new javax.swing.JFormattedTextField();
        txt_dataVencimento = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_dataPagamento = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_valorPago = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_codigoDeBarras = new javax.swing.JTextField();
        check_VencimentoDiasUteis = new javax.swing.JCheckBox();
        check_transferencias = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_codigoContaCorrenteOrigem = new javax.swing.JFormattedTextField();
        bt_pesquisaContaCorrenteOrigem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        label_contaCorrenteOrigem = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txt_codigoContaCorrenteDestino = new javax.swing.JFormattedTextField();
        bt_pesquisaContaCorrenteDestino = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        label_contaCorrenteDestino = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        txt_codigoDespesaTipo = new javax.swing.JFormattedTextField();
        bt_pesquisaDespesasTipo = new javax.swing.JButton();
        label_descricaoDespesaTipo = new javax.swing.JLabel();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        label_alteracao = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        bt_cadastroDespesasTipo = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bt_sair1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de despesas e transferências");
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
        jLabel1.setText("Informações da despesa ou transferência");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código:");

        try {
            txt_codigoDespesa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoDespesa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoDespesa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoDespesaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoDespesaFocusLost(evt);
            }
        });

        bt_novo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descrição:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Valor devido:");

        txt_valorDespesa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorDespesaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorDespesaFocusLost(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Duração (Meses):");

        try {
            txt_qtdMeses.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_qtdMeses.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_qtdMeses.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_qtdMesesFocusLost(evt);
            }
        });

        try {
            txt_dataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataVencimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataVencimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataVencimentoFocusLost(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Data da transação:");

        try {
            txt_dataPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataPagamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataPagamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataPagamentoFocusLost(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Valor da transação:");

        txt_valorPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorPagoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorPagoFocusLost(evt);
            }
        });

        jLabel9.setText("Vencimento:");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Número doc:");

        check_VencimentoDiasUteis.setSelected(true);
        check_VencimentoDiasUteis.setText("Vencimento somente em dias úteis");

        check_transferencias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        check_transferencias.setText("Transferência entre contas");
        check_transferencias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check_transferenciasItemStateChanged(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Débito (Origem)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Conta Corrente:");

        try {
            txt_codigoContaCorrenteOrigem.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoContaCorrenteOrigem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoContaCorrenteOrigem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoContaCorrenteOrigemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoContaCorrenteOrigemFocusLost(evt);
            }
        });

        bt_pesquisaContaCorrenteOrigem.setText("...");
        bt_pesquisaContaCorrenteOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaContaCorrenteOrigemActionPerformed(evt);
            }
        });

        label_contaCorrenteOrigem.setEditable(false);
        label_contaCorrenteOrigem.setColumns(20);
        label_contaCorrenteOrigem.setRows(5);
        label_contaCorrenteOrigem.setAutoscrolls(false);
        label_contaCorrenteOrigem.setFocusable(false);
        jScrollPane1.setViewportView(label_contaCorrenteOrigem);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_codigoContaCorrenteOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_pesquisaContaCorrenteOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_codigoContaCorrenteOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaContaCorrenteOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 64, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaContaCorrenteOrigem, jLabel6, txt_codigoContaCorrenteOrigem});

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Crédito (Destino)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Conta Corrente:");

        try {
            txt_codigoContaCorrenteDestino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoContaCorrenteDestino.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoContaCorrenteDestino.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoContaCorrenteDestinoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoContaCorrenteDestinoFocusLost(evt);
            }
        });

        bt_pesquisaContaCorrenteDestino.setText("...");
        bt_pesquisaContaCorrenteDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaContaCorrenteDestinoActionPerformed(evt);
            }
        });

        label_contaCorrenteDestino.setEditable(false);
        label_contaCorrenteDestino.setColumns(20);
        label_contaCorrenteDestino.setRows(5);
        label_contaCorrenteDestino.setAutoscrolls(false);
        label_contaCorrenteDestino.setFocusable(false);
        jScrollPane3.setViewportView(label_contaCorrenteDestino);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Tipo de saída:");

        try {
            txt_codigoDespesaTipo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoDespesaTipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoDespesaTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoDespesaTipoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoDespesaTipoFocusLost(evt);
            }
        });

        bt_pesquisaDespesasTipo.setText("...");
        bt_pesquisaDespesasTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaDespesasTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_codigoContaCorrenteDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(txt_codigoDespesaTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_pesquisaDespesasTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(bt_pesquisaContaCorrenteDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_descricaoDespesaTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(txt_codigoDespesaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label_descricaoDespesaTipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txt_codigoContaCorrenteDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 47, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bt_pesquisaDespesasTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaContaCorrenteDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaDespesasTipo, jLabel11, jLabel13, label_descricaoDespesaTipo, txt_codigoContaCorrenteDestino, txt_codigoDespesaTipo});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(check_transferencias, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_codigoDeBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_descricaoDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_valorDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_codigoDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bt_novo))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_qtdMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_dataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(check_VencimentoDiasUteis, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_valorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_dataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {check_VencimentoDiasUteis, check_transferencias});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel2, jLabel3, jLabel4, jLabel5});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel2, jPanel3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigoDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_transferencias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_descricaoDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_valorDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_codigoDeBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_qtdMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(check_VencimentoDiasUteis, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_dataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_valorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {check_VencimentoDiasUteis, jLabel10, jLabel3, jLabel4, jLabel5, jLabel9, txt_codigoDeBarras, txt_dataVencimento, txt_descricaoDespesa, txt_qtdMeses, txt_valorDespesa});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, check_transferencias, jLabel2, txt_codigoDespesa});

        bt_incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_incluir.setText("Incluir");
        bt_incluir.setEnabled(false);
        bt_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirActionPerformed(evt);
            }
        });

        bt_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Save.png"))); // NOI18N
        bt_alterar.setText("Alterar");
        bt_alterar.setEnabled(false);
        bt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarActionPerformed(evt);
            }
        });

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        bt_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisa.setText("Pesquisa");
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaActionPerformed(evt);
            }
        });

        label_alteracao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenu1.setText("Arquivo");

        jMenu2.setText("Cadastro");

        bt_cadastroDespesasTipo.setText("Tipo de Despesas");
        bt_cadastroDespesasTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroDespesasTipoActionPerformed(evt);
            }
        });
        jMenu2.add(bt_cadastroDespesasTipo);

        jMenuItem1.setText("Formas de Pagamentos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

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

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_alterar, bt_incluir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_alteracao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_incluir, bt_pesquisa, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoDespesaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoDespesaFocusGained
        if(txt_codigoDespesa.getText().replace(" ", "").equals(""))
            return;
        if(txt_codigoDespesa.isEditable() == false)
            return;
        operacao = "";
        ReiniciaCampos();
        HabilitaBotoes();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoDespesaFocusGained

    private void txt_codigoDespesaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoDespesaFocusLost
        if(txt_codigoDespesa.getText().replace(" ", "").equals(""))
            return;
        if(somostra.equals("S"))
            return;
        bd.codigoDespesa  = Integer.parseInt(txt_codigoDespesa.getText());
        if(bd.codigoDespesa == 0)return;
        sql = "select * from tb_despesas where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoDespesa = " + bd.codigoDespesa + ";";
        PegaDespesa();
    }//GEN-LAST:event_txt_codigoDespesaFocusLost

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        
        bd.codigoDespesa  = PegProReg.PegaProximoRegistro("tb_despesas", "codigoDespesa", "");
        txt_codigoDespesa.setText(fc.FormataCampo(String.valueOf(bd.codigoDespesa), 6, 0));
        
        operacao = "I";
        HabilitaBotoes();
        txt_descricaoDespesa.grabFocus();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_valorDespesaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDespesaFocusGained
        if(!txt_valorDespesa.getText().equals(""))
            txt_valorDespesa.setText(TransStrDou.TransformaValorStringeDouble(txt_valorDespesa.getText(), 0));
    }//GEN-LAST:event_txt_valorDespesaFocusGained

    private void txt_valorDespesaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorDespesaFocusLost
        try{
            if(!txt_valorDespesa.getText().equals(""))
                txt_valorDespesa.setText(TransStrDou.TransformaValorStringeDouble(txt_valorDespesa.getText(), 0));
            HabilitaBotoes();
        }catch(Exception erro){
            mensagem = "Valor de despesa inválido!";
            new MostraMensagem(mensagem);
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(false);
        }
    }//GEN-LAST:event_txt_valorDespesaFocusLost

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        bd.qtdMeses = Integer.parseInt(fc.FormataCampo(txt_qtdMeses.getText().replace(" ", ""), 2, 0));
        if(bd.qtdMeses < 1)
            bd.qtdMeses = 1;
        bd.dataVencimento = txt_dataVencimento.getText().replace(" ", "");
        bd.dataVencimento = bd.dataVencimento.replace("/", "");
//        if(!bd.dataVencimento.equals(""))
//            if(JOptionPane.showConfirmDialog(null, "Confirma data de Vencimento " + txt_dataVencimento.getText() + "?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
//                return;
        if(check_transferencias.isSelected() == false){
            IncluirDespesa();
            return;
        }
        bd.qtdMeses     = 0;
        IncluirTransferencia();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void txt_qtdMesesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_qtdMesesFocusLost
        txt_qtdMeses.setText(fc.FormataCampo(txt_qtdMeses.getText(), 2, 0));
    }//GEN-LAST:event_txt_qtdMesesFocusLost

    private void txt_valorPagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorPagoFocusLost
//        try{
            if(!txt_valorPago.getText().equals(""))
                txt_valorPago.setText(TransStrDou.TransformaValorStringeDouble(txt_valorPago.getText(), 0));
            HabilitaBotoes();
//        }catch(Exception erro){
//            Mensagem = "Valor Pago inválido!";
//            new MostraMensagem(mensagem);
//            bt_incluir.setEnabled(false);
//            bt_alterar.setEnabled(false);
//        }
    }//GEN-LAST:event_txt_valorPagoFocusLost

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql =  "update tb_despesas set codigoDespesaTipo = "    + bd.codigoDespesaTipo      + ", "
                                    + "descricaoDespesa = '"    + bd.descricaoDespesa       + "', "
                                    + "valorDespesa = "         + bd.valorDespesa           + ", "
                                    + "codigoDeBarras = "       + bd.codigoDeBarras         + ", "
                                    + "dataVencimento = "       + bd.dataVencimento         + ", "
                                    + "codigoContaCorrente = "  + bd.codigoContaCorrente    + ", "
                                    + "dataPagamento = "        + bd.dataPagamento          + ", "
                                    + "valorPago = "            + bd.valorPago              + ", "
                                    + "idEmpresaAlterou = "     + bd.idEmpresaAlterou       + ", "
                                    + "codigoGrupoAlterou = "   + bd.codigoGrupoAlterou     + ", "
                                    + "codigoEmpresaAlterou = " + bd.codigoEmpresaAlterou   + ", "
                                    + "dataAlterou = '"         + bd.dataAlterou            + "', "
                                    + "horaAlterou = '"         + bd.horaAlterou            + "', "
                                    + "usuarioAlterou = "       + bd.usuarioAlterou         + " "
                                    + "where idDespesa = "  + bd.idDespesa              + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        if(bd.transferencia == 0)
            mensagem = "Despesa alterada com sucesso!";
        else
            mensagem = "Transferência alterada com sucesso!";
        new MostraMensagem(mensagem);
        txt_codigoDespesa.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuDespesa == 0){
            AbreDespesaTipo();
            return;
        }
        abriuDespesa = 0;
        retorno = DesCon.getRetorno();
        if(retorno.equals(""))
            return;
        bd.idDespesa = Integer.parseInt(retorno);
        sql = "select * from tb_despesas where idDespesa = " + bd.idDespesa + ";";
        PegaDespesa();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbreDespesaTipo(){
        if(abriuDespesaTipo == 0){
            abreContaCorrenteOrigem();
            return;
        }
        abriuDespesaTipo = 0;
        retorno = DesTipoCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoDespesaTipo.setText(fc.FormataCampo(retorno, 2, 0));
        bdt.codigoDespesaTipo = Integer.parseInt(txt_codigoDespesaTipo.getText());
        if(bdt.codigoDespesaTipo == 0)
            return;
        sql = "select * from tb_despesas_tipo where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoDespesaTipo = " + bdt.codigoDespesaTipo + ";";
        PegaDespesasTipo();
    }
    
    private void abreContaCorrenteOrigem(){
        if(abriuContaCorrente == 0)
            return;
        abriuContaCorrente = 0;
        retorno = ConCorCon.getRetornoContaCorrente();
        if(retorno.equals(""))
            return;
        bcc.idContaCorrente = Integer.parseInt(retorno);
        if(bcc.idContaCorrente == 0)
            return;
        sql = "select idContaCorrente, idEmpresa, codigoGrupo, codigoEmpresa, codigoContaCorrente, idBanco, numeroAgencia, digitoVerificadorAgencia, numeroContaCorrente, digitoVerificador from tb_contacorrente where idContaCorrente = " + bcc.idContaCorrente + ";";
        PegaContaCorrente();
        if(saida.equalsIgnoreCase("O")){
            txt_codigoContaCorrenteOrigem.setText(fc.FormataCampo(retorno, 6, 0));
            bcc.codigoContaCorrente = Integer.parseInt(txt_codigoContaCorrenteOrigem.getText());
        }else{
            txt_codigoContaCorrenteDestino.setText(fc.FormataCampo(retorno, 6, 0));
            bcc.codigoContaCorrente = Integer.parseInt(txt_codigoContaCorrenteDestino.getText());
        }
    }
    
    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        if(DesCon != null)if(DesCon.isVisible()){
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuDespesa = 1;
        DesCon = new DespesasConsulta("S");
        DesCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void txt_codigoContaCorrenteOrigemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoContaCorrenteOrigemFocusLost
        if(txt_codigoDespesa.getText().replace(" ", "").equals(""))
            return;
        if(somostra.equals("S"))
            return;
        txt_codigoContaCorrenteOrigem.setText(fc.FormataCampo(txt_codigoContaCorrenteOrigem.getText(), 6, 0));
        bcc.codigoContaCorrente = Integer.parseInt(txt_codigoContaCorrenteOrigem.getText());
        if(bcc.codigoContaCorrente == 0)
            return;
        saida = "O";
        sql = "select idContaCorrente, idEmpresa, codigoGrupo, codigoEmpresa, codigoContaCorrente, idBanco, numeroAgencia, digitoVerificadorAgencia, numeroContaCorrente, digitoVerificador from tb_contacorrente where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoContaCorrente = " + bcc.codigoContaCorrente + ";";
        PegaContaCorrente();
    }//GEN-LAST:event_txt_codigoContaCorrenteOrigemFocusLost

    private void bt_pesquisaContaCorrenteOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaContaCorrenteOrigemActionPerformed
        if(ConCorCon != null)if(ConCorCon.isVisible()){
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        saida = "O";
        abriuContaCorrente = 1;
        ConCorCon = new ContaCorrenteConsulta("N");
        ConCorCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaContaCorrenteOrigemActionPerformed

    private void txt_codigoContaCorrenteOrigemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoContaCorrenteOrigemFocusGained
        txt_codigoContaCorrenteOrigem.setSelectionStart(0);
        txt_codigoContaCorrenteOrigem.setSelectionEnd  (txt_codigoContaCorrenteOrigem.getText().length());
        label_contaCorrenteOrigem.setText("");
    }//GEN-LAST:event_txt_codigoContaCorrenteOrigemFocusGained

    private void bt_cadastroDespesasTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroDespesasTipoActionPerformed
        if(DesTipoCad != null)if(DesTipoCad.isVisible()){
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add(0);
        DesTipoCad = new DespesasTipoCadastro(parametros);
        DesTipoCad.setVisible(true);
    }//GEN-LAST:event_bt_cadastroDespesasTipoActionPerformed

    private void txt_codigoDespesaTipoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoDespesaTipoFocusGained
        txt_codigoDespesaTipo.setSelectionStart(0);
        txt_codigoDespesaTipo.setSelectionEnd  (txt_codigoDespesaTipo.getText().length());
        label_descricaoDespesaTipo.setText("");
    }//GEN-LAST:event_txt_codigoDespesaTipoFocusGained

    private void txt_codigoDespesaTipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoDespesaTipoFocusLost
        if(txt_codigoDespesaTipo.getText().replace(" ", "").equals(""))
            return;
        if(somostra.equals("S"))
            return;
        txt_codigoDespesaTipo.setText(fc.FormataCampo(txt_codigoDespesaTipo.getText(), 2, 0));
        bdt.codigoDespesaTipo = Integer.parseInt(txt_codigoDespesaTipo.getText());
        if(bdt.codigoDespesaTipo == 0)
            return;
        sql = "select * from tb_despesas_tipo where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoDespesaTipo = " + bdt.codigoDespesaTipo + ";";
        PegaDespesasTipo();
    }//GEN-LAST:event_txt_codigoDespesaTipoFocusLost

    private void bt_pesquisaDespesasTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaDespesasTipoActionPerformed
        if(DesTipoCon != null)if(DesTipoCon.isVisible()){
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuDespesaTipo = 1;
        parametros.clear();
        parametros.add("N");
        DesTipoCon = new DespesasTipoConsulta(parametros);
        DesTipoCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaDespesasTipoActionPerformed

    private void txt_valorPagoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorPagoFocusGained
        if(!txt_valorPago.getText().equals(""))
            txt_valorPago.setText(TransStrDou.TransformaValorStringeDouble(txt_valorPago.getText(), 1));
    }//GEN-LAST:event_txt_valorPagoFocusGained

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        if(bd.codigoDespesa != 0){
            sql = "select * from tb_despesas where idDespesa = " + bd.idDespesa + ";";
            PegaDespesa();
        }
        if(somostra.equals("S")){
            txt_codigoDespesa           .setEditable(false);
            bt_novo                     .setEnabled (false);
            bt_incluir                  .setVisible (false);
            bt_alterar                  .setVisible (false);
            bt_pesquisa                 .setVisible (false);
            bt_pesquisaDespesasTipo     .setEnabled (false);
            bt_pesquisaContaCorrenteOrigem    .setEnabled (false);
        }
        if(somostra.equals("SN"))
            bt_pesquisa                 .setVisible (false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(DesCon       != null)DesCon      .dispose();
        if(ConCorCad    != null)ConCorCad .dispose();
        if(ConCorCon    != null)ConCorCon .dispose();
        if(DesTipoCad   != null)DesTipoCad  .dispose();
        if(DesTipoCon   != null)DesTipoCon  .dispose();
    }//GEN-LAST:event_formWindowClosed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(ConCorCad != null)if(ConCorCad.isVisible()){
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        ConCorCad = new ContaCorrenteCadastro("N", 0);
        ConCorCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txt_dataVencimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataVencimentoFocusLost
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
        if(ValData.ValidaData(txt_dataVencimento.getText()).equals("N"))
            return;
        HabilitaBotoes();
    }//GEN-LAST:event_txt_dataVencimentoFocusLost

    private void txt_dataPagamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataPagamentoFocusLost
        bd.dataPagamento    = txt_dataPagamento.getText().replace(" ", "");
        bd.dataPagamento    = bd.dataPagamento.replace("/", "");
        if(bd.dataPagamento.equals(""))
            return;
        if(ValData.ValidaData(txt_dataPagamento.getText()).equals("N")){
            mensagem = "Data de Pagamento inválida!";
            new MostraMensagem(mensagem);
            return;
        }
    }//GEN-LAST:event_txt_dataPagamentoFocusLost

    private void txt_codigoContaCorrenteDestinoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoContaCorrenteDestinoFocusGained
        txt_codigoContaCorrenteDestino.setSelectionStart(0);
        txt_codigoContaCorrenteDestino.setSelectionEnd  (txt_codigoContaCorrenteDestino.getText().length());
        label_contaCorrenteDestino.setText("");
    }//GEN-LAST:event_txt_codigoContaCorrenteDestinoFocusGained

    private void txt_codigoContaCorrenteDestinoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoContaCorrenteDestinoFocusLost
        if(txt_codigoDespesa.getText().replace(" ", "").equals(""))
            return;
        if(somostra.equals("S"))
            return;
        txt_codigoContaCorrenteDestino.setText(fc.FormataCampo(txt_codigoContaCorrenteDestino.getText(), 6, 0));
        bcc.codigoContaCorrente = Integer.parseInt(txt_codigoContaCorrenteDestino.getText());
        if(bcc.codigoContaCorrente == 0)
            return;
        saida = "D";
        sql = "select idContaCorrente, idEmpresa, codigoGrupo, codigoEmpresa, codigoContaCorrente, idBanco, numeroAgencia, digitoVerificadorAgencia, numeroContaCorrente, digitoVerificador from tb_contacorrente where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoContaCorrente = " + bcc.codigoContaCorrente + ";";
        PegaContaCorrente();
    }//GEN-LAST:event_txt_codigoContaCorrenteDestinoFocusLost

    private void bt_pesquisaContaCorrenteDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaContaCorrenteDestinoActionPerformed
        if(ConCorCon != null)if(ConCorCon.isVisible()){
            mensagem = "Tela já Aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        saida = "D";
        abriuContaCorrente = 1;
        ConCorCon = new ContaCorrenteConsulta("N");
        ConCorCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaContaCorrenteDestinoActionPerformed

    private void check_transferenciasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_check_transferenciasItemStateChanged
        VerificaTransferencia(true);
    }//GEN-LAST:event_check_transferenciasItemStateChanged
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JMenuItem bt_cadastroDespesasTipo;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_pesquisaContaCorrenteDestino;
    private javax.swing.JButton bt_pesquisaContaCorrenteOrigem;
    private javax.swing.JButton bt_pesquisaDespesasTipo;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JCheckBox check_VencimentoDiasUteis;
    private javax.swing.JCheckBox check_transferencias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel label_alteracao;
    private javax.swing.JTextArea label_contaCorrenteDestino;
    private javax.swing.JTextArea label_contaCorrenteOrigem;
    private javax.swing.JLabel label_descricaoDespesaTipo;
    private javax.swing.JFormattedTextField txt_codigoContaCorrenteDestino;
    private javax.swing.JFormattedTextField txt_codigoContaCorrenteOrigem;
    private javax.swing.JTextField txt_codigoDeBarras;
    private javax.swing.JFormattedTextField txt_codigoDespesa;
    private javax.swing.JFormattedTextField txt_codigoDespesaTipo;
    private javax.swing.JFormattedTextField txt_dataPagamento;
    private javax.swing.JFormattedTextField txt_dataVencimento;
    private javax.swing.JTextField txt_descricaoDespesa;
    private javax.swing.JFormattedTextField txt_qtdMeses;
    private javax.swing.JTextField txt_valorDespesa;
    private javax.swing.JTextField txt_valorPago;
    // End of variables declaration//GEN-END:variables
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir              .setEnabled(true);
            bt_alterar              .setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir              .setEnabled(false);
            bt_alterar              .setEnabled(true);
            return;
        }
        bt_incluir                  .setEnabled(false);
        bt_alterar                  .setEnabled(false);
    }
    
    private void ReiniciaCampos(){
        i = 0;
        txt_codigoDespesa               .setText("");
        txt_codigoDespesaTipo           .setText("");
        label_descricaoDespesaTipo      .setText("");
        txt_descricaoDespesa            .setText("");
        txt_valorDespesa                .setText("");
        txt_codigoDeBarras              .setText("");
        txt_qtdMeses                    .setText("01");
        txt_dataVencimento              .setText("");
        txt_codigoContaCorrenteOrigem   .setText("");
        label_contaCorrenteOrigem       .setText("");
        txt_codigoContaCorrenteDestino  .setText("");
        label_contaCorrenteDestino      .setText("");
        txt_dataPagamento               .setText("");
        txt_valorPago                   .setText("");
        label_alteracao                 .setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        check_transferencias            .setEnabled     (Habilita);
        check_transferencias            .setFocusable   (Habilita);
        txt_descricaoDespesa            .setEditable    (Habilita);
        txt_descricaoDespesa            .setFocusable   (Habilita);
        txt_codigoDeBarras              .setEditable    (Habilita);
        txt_codigoDeBarras              .setFocusable   (Habilita);
        txt_codigoContaCorrenteOrigem   .setEditable    (Habilita);
        txt_codigoContaCorrenteOrigem   .setFocusable   (Habilita);
        bt_pesquisaContaCorrenteOrigem  .setEnabled     (Habilita);
        bt_pesquisaContaCorrenteOrigem  .setFocusable   (Habilita);
        txt_dataPagamento               .setEditable    (Habilita);
        txt_dataPagamento               .setFocusable   (Habilita);
        txt_valorPago                   .setEditable    (Habilita);
        txt_valorPago                   .setFocusable   (Habilita);
        
        VerificaTransferencia(Habilita);
    }
    
    private void VerificaTransferencia(boolean Verifica){
        check_VencimentoDiasUteis       .setSelected(false);
        txt_qtdMeses                    .setText("");
        txt_valorDespesa                .setText("");
        txt_dataVencimento              .setText("");
        txt_codigoDespesaTipo           .setText("");
        txt_codigoContaCorrenteDestino  .setText("");
        label_contaCorrenteDestino      .setText("");
        label_descricaoDespesaTipo      .setText("");
        txt_qtdMeses                    .setEditable    (false);
        txt_qtdMeses                    .setFocusable   (false);
        txt_valorDespesa                .setEditable    (false);
        txt_valorDespesa                .setEditable    (false);
        txt_valorDespesa                .setFocusable   (false);
        txt_dataVencimento              .setEditable    (false);
        txt_dataVencimento              .setFocusable   (false);
        check_VencimentoDiasUteis       .setEnabled     (false);
        txt_codigoDespesaTipo           .setEditable    (false);
        txt_codigoDespesaTipo           .setFocusable   (false);
        bt_pesquisaDespesasTipo         .setEnabled     (false);
        bt_pesquisaDespesasTipo         .setFocusable   (false);
        txt_codigoContaCorrenteDestino  .setEditable    (false);
        txt_codigoContaCorrenteDestino  .setFocusable   (false);
        bt_pesquisaContaCorrenteDestino .setEnabled     (false);
        bt_pesquisaContaCorrenteDestino .setFocusable   (false);
//        label_contaCorrenteDestino      .setEnabled     (false);
        
        if(Verifica == false)
            return;
        
        transferencias = 0;
        txt_qtdMeses                    .setEditable    (true);
        txt_qtdMeses                    .setFocusable   (true);
        txt_valorDespesa                .setEditable    (true);
        txt_valorDespesa                .setEditable    (true);
        txt_valorDespesa                .setFocusable   (true);
        txt_dataVencimento              .setEditable    (true);
        txt_dataVencimento              .setFocusable   (true);
        check_VencimentoDiasUteis       .setEnabled     (true);
        txt_codigoDespesaTipo           .setEditable    (true);
        txt_codigoDespesaTipo           .setFocusable   (true);
        bt_pesquisaDespesasTipo         .setEnabled     (true);
        bt_pesquisaDespesasTipo         .setFocusable   (true);
        txt_codigoContaCorrenteDestino  .setEditable    (false);
        txt_codigoContaCorrenteDestino  .setFocusable   (false);
        bt_pesquisaContaCorrenteDestino .setEnabled     (false);
        bt_pesquisaContaCorrenteDestino .setFocusable   (false);
//        label_contaCorrenteDestino      .setEnabled     (false);
        if(check_transferencias.isSelected() == false)
            return;
        transferencias = 1;
        txt_qtdMeses                    .setEditable    (false);
        txt_qtdMeses                    .setFocusable   (false);
        txt_valorDespesa                .setEditable    (false);
        txt_valorDespesa                .setEditable    (false);
        txt_valorDespesa                .setFocusable   (false);
        txt_dataVencimento              .setEditable    (false);
        txt_dataVencimento              .setFocusable   (false);
        check_VencimentoDiasUteis       .setEnabled     (false);
        txt_codigoDespesaTipo           .setEditable    (false);
        txt_codigoDespesaTipo           .setFocusable   (false);
        bt_pesquisaDespesasTipo         .setEnabled     (false);
        bt_pesquisaDespesasTipo         .setFocusable   (false);
        txt_codigoContaCorrenteDestino  .setEditable    (true);
        txt_codigoContaCorrenteDestino  .setFocusable   (true);
        bt_pesquisaContaCorrenteDestino .setEnabled     (true);
        bt_pesquisaContaCorrenteDestino .setFocusable   (true);
//        label_contaCorrenteDestino      .setEnabled     (true);
        txt_descricaoDespesa.grabFocus();
    }
    
    private void PegaDespesa(){
        dadosDespesas.clear();
        dadosDespesas = parametrosNS.dao.Consulta(sql);
        if(dadosDespesas.isEmpty()){
            mensagem = "Despesa n°" + bd.codigoDespesa + " não encontrada!";
            new MostraMensagem(mensagem);
            return;
        }
        operacao = "A";
        HabilitaCampos(true);
        HabilitaBotoes();
        PegaDadosDespesa();
    }
    
    private void PegaDadosDespesa(){
        for(int i = 0; i < dadosDespesas.size(); i++){
            bd = new BeanDespesas();
            if(dadosDespesas.get(i).get(0) != null)
                bd.idDespesa                 = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(0)));
            if(dadosDespesas.get(i).get(1) != null)
                bd.idEmpresa                 = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(1)));
            if(dadosDespesas.get(i).get(2)  != null)
                bd.codigoGrupo               = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(2)));
            if(dadosDespesas.get(i).get(3)  != null)
                bd.codigoEmpresa             = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(3)));
            if(dadosDespesas.get(i).get(4)  != null)
                bd.codigoDespesa             = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(4)));
            if(dadosDespesas.get(i).get(5)  != null)
                bd.codigoDespesaTipo         = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(5)));
                bd.descricaoDespesa          =                    String.valueOf(dadosDespesas.get(i).get(6));
            if(dadosDespesas.get(i).get(7)  != null)
                bd.valorDespesa              = Double.parseDouble(String.valueOf(dadosDespesas.get(i).get(7)));
            if(dadosDespesas.get(i).get(8)  != null)
                bd.codigoUsuario             = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(8)));
                bd.dataCadastro              =                    String.valueOf(dadosDespesas.get(i).get(9));
                bd.horaCadastro              =                    String.valueOf(dadosDespesas.get(i).get(10));
                bd.codigoDeBarras            =                    String.valueOf(dadosDespesas.get(i).get(11));
            if(dadosDespesas.get(i).get(12) != null)
                bd.qtdMeses                  = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(12)));
                bd.dataVencimento            =                    String.valueOf(dadosDespesas.get(i).get(13));
            if(dadosDespesas.get(i).get(14) != null)
                bd.codigoContaCorrente       = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(14)));
                bd.dataPagamento             =                    String.valueOf(dadosDespesas.get(i).get(15));
            if(dadosDespesas.get(i).get(16) != null)
                bd.valorPago                 = Double.parseDouble(String.valueOf(dadosDespesas.get(i).get(16)));
                bd.dataAlterou               =                    String.valueOf(dadosDespesas.get(i).get(17));
                bd.horaAlterou               =                    String.valueOf(dadosDespesas.get(i).get(18));
            if(dadosDespesas.get(i).get(19) != null)
                bd.usuarioAlterou            = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(19)));
            if(dadosDespesas.get(i).get(20) != null)
                bd.idEmpresaAlterou          = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(20)));
            if(dadosDespesas.get(i).get(21) != null)
                bd.codigoGrupoAlterou        = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(21)));
            if(dadosDespesas.get(i).get(22) != null)
                bd.codigoEmpresaAlterou      = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(22)));
            if(dadosDespesas.get(i).get(23) != null)
                bd.codigoContaCorrenteDestino= Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(23)));
            if(dadosDespesas.get(i).get(24) != null)
                bd.transferencia             = Integer.parseInt(  String.valueOf(dadosDespesas.get(i).get(24)));
        }
        txt_codigoDespesa.setText(fc.FormataCampo(String.valueOf(bd.codigoDespesa), 6, 0));
        switch(bd.transferencia){
            case 0: check_transferencias.setSelected(false);
                    check_transferencias.setEnabled (false);    break;
            case 1: check_transferencias.setSelected(true);     break;
        }
        bdt.codigoDespesaTipo     = bd.codigoDespesaTipo;
        if(bd.transferencia == 1){
            bdt.codigoDespesaTipo = 0;
        }
        sql = "select idDespesaTipo, idEmpresa, codigoGrupo, codigoEmpresa, codigoDespesaTipo, descricaoDespesaTipo from tb_despesas_tipo where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoDespesaTipo = " + bdt.codigoDespesaTipo + ";";
        if(bd.codigoDespesaTipo != 0){
            PegaDespesasTipo();
        }
        txt_descricaoDespesa            .setText(bd.descricaoDespesa);
        if(bd.transferencia == 0)
            txt_valorDespesa                .setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bd.valorDespesa), 0));
        txt_codigoDeBarras              .setText(bd.codigoDeBarras);
        if(bd.transferencia == 0)
            txt_qtdMeses                    .setText(fc.FormataCampo(String.valueOf(bd.qtdMeses), 2, 0));
        bd.dataVencimento               = invdata.inverterData(bd.dataVencimento, 1);
        txt_dataVencimento              .setText(bd.dataVencimento);
        
        saida = "O";
        bcc.idEmpresa           = bd.idEmpresa;
        bcc.codigoGrupo         = bd.codigoGrupo;
        bcc.codigoEmpresa       = bd.codigoEmpresa;
        bcc.codigoContaCorrente = bd.codigoContaCorrente;
        sql = "select idContaCorrente, idEmpresa, codigoGrupo, codigoEmpresa, codigoContaCorrente, idBanco, numeroAgencia, digitoVerificadorAgencia, numeroContaCorrente, digitoVerificador from tb_contacorrente where idEmpresa = " + bcc.idEmpresa + " and codigoContaCorrente = " + bcc.codigoContaCorrente + ";";
        PegaContaCorrente();
        
        saida = "D";
        if(bd.transferencia == 0){saida = "";}
        bcc.idEmpresa           = bd.idEmpresa;
        bcc.codigoGrupo         = bd.codigoGrupo;
        bcc.codigoEmpresa       = bd.codigoEmpresa;
        bcc.codigoContaCorrente = bd.codigoContaCorrente;
        sql = "select idContaCorrente, idEmpresa, codigoGrupo, codigoEmpresa, codigoContaCorrente, idBanco, numeroAgencia, digitoVerificadorAgencia, numeroContaCorrente, digitoVerificador from tb_contacorrente where idEmpresa = " + bcc.idEmpresa + " and codigoContaCorrente = " + bcc.codigoContaCorrente + ";";
        if(bd.transferencia != 0){
            PegaContaCorrente();
        }
        
        if(bd.dataPagamento != null)
            bd.dataPagamento = invdata.inverterData(bd.dataPagamento, 1);
        else
            bd.dataPagamento = "";
        txt_dataPagamento.setText(bd.dataPagamento);
        
        txt_valorPago                   .setText(TransStrDou.TransformaValorStringeDouble(String.valueOf(bd.valorPago), 0));
        if(bd.usuarioAlterou != 0){
            bu.usuario      = "NS3";
            bd.dataAlterou    = invdata.inverterData(bd.dataAlterou, 1);
            if(parametrosNS.bu.codigoUsuario != 999){
                bu.idEmpresa        = bd.idEmpresaAlterou;
                bu.codigoGrupo      = bd.codigoGrupoAlterou;
                bu.codigoEmpresa    = bd.codigoEmpresaAlterou;
                bu.codigoUsuario    = bd.usuarioAlterou;
                PegaUsuario();
            }
            label_alteracao.setText("Última alteração feita em " + bd.dataAlterou + " às " + bd.horaAlterou + " por " + bu.usuario);
        }
    }
    
    private void PegaDespesasTipo(){
        dadosDespesasTipo.clear();
        dadosDespesasTipo = parametrosNS.dao.Consulta(sql);
        if(dadosDespesasTipo.isEmpty()){
            label_descricaoDespesaTipo.setText("Não encontrada!");
            bt_incluir  .setEnabled (false);
            bt_alterar  .setEnabled (false);
            mensagem = "Tipo de despesa nº" + bdt.codigoDespesaTipo + " não encontrada!";
            new MostraMensagem(mensagem);
            return;
        }
        HabilitaBotoes();
        PegaDadosDespesasTipo();
    }
    
    private void PegaDadosDespesasTipo(){
        for(int i = 0; i < dadosDespesasTipo.size(); i++){
            bdt = new BeanDespesasTipo();
            bdt.idDespesaTipo         = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(0)));
            bdt.idEmpresa             = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(1)));
            bdt.codigoGrupo           = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(2)));
            bdt.codigoEmpresa         = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(3)));
            bdt.codigoDespesaTipo     = Integer.parseInt(  String.valueOf(dadosDespesasTipo.get(i).get(4)));
            bdt.descricaoDespesaTipo  =                    String.valueOf(dadosDespesasTipo.get(i).get(5));
        }
        txt_codigoDespesaTipo.setText(fc.FormataCampo(String.valueOf(bdt.codigoDespesaTipo), 2, 0));
        label_descricaoDespesaTipo.setText(bdt.descricaoDespesaTipo);
    }
    
    private void PegaContaCorrente(){
        dadosContaCorrente.clear();
        dadosContaCorrente = parametrosNS.dao.Consulta(sql);
        if(dadosContaCorrente.isEmpty()){
            label_contaCorrenteOrigem.setText("Não encontrada!");
            bt_incluir  .setEnabled (false);
            bt_alterar  .setEnabled (false);
            mensagem = "Conta Corrente não encontrada!";
            new MostraMensagem(mensagem);
            return;
        }
        HabilitaBotoes();
        PegaDadosContaCorrente();
    }
    
    private void PegaDadosContaCorrente(){
        String agencia          = "";
        String contaCorrente    = "";
        for(int i = 0; i < dadosContaCorrente.size(); i++){
            bcc = new BeanContaCorrente();
        if(dadosContaCorrente.get(i).get(0) != null)
            bcc.idContaCorrente             = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(0)));
        if(dadosContaCorrente.get(i).get(1) != null)
            bcc.idEmpresa                   = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(1)));
        if(dadosContaCorrente.get(i).get(2) != null)
            bcc.codigoGrupo                 = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(2)));
        if(dadosContaCorrente.get(i).get(3) != null)
            bcc.codigoEmpresa               = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(3)));
        if(dadosContaCorrente.get(i).get(4) != null)
            bcc.codigoContaCorrente         = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(4)));
        if(dadosContaCorrente.get(i).get(5) != null)
            bcc.idBanco                     = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(5)));
        if(dadosContaCorrente.get(i).get(6) != null)
            bcc.numeroAgencia               = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(6)));
        if(dadosContaCorrente.get(i).get(7) != null)
            bcc.digitoVerificadorAgencia    = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(7)));
        if(dadosContaCorrente.get(i).get(8) != null)
            bcc.numeroContaCorrente         = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(8)));
        if(dadosContaCorrente.get(i).get(9) != null)
            bcc.digitoVerificador           = Integer.parseInt(  String.valueOf(dadosContaCorrente.get(i).get(9)));
            
            be.codigoGrupo      = bcc.codigoGrupo;
            be.codigoEmpresa    = bcc.codigoEmpresa;
            PegaEmpresa();
            
            bb.idBanco  = bcc.idBanco;
            if(bb.idBanco != 999)
                PegaBanco();
            
            agencia             = fc.FormataCampo(String.valueOf(bcc.numeroAgencia), 4, 0);
            if(bcc.digitoVerificadorAgencia != 0)
                agencia        += "-" + String.valueOf(bcc.digitoVerificadorAgencia);
            contaCorrente   = fc.FormataCampo(String.valueOf(bcc.numeroContaCorrente), 5, 0) + "-" + String.valueOf(bcc.digitoVerificador);
        }
        if(saida.equalsIgnoreCase("O")){
            txt_codigoContaCorrenteOrigem .setText(fc.FormataCampo(String.valueOf(bcc.codigoContaCorrente), 6, 0));
            label_contaCorrenteOrigem.setText("Empresa: " + fc.FormataCampo(String.valueOf(be.codigoGrupo), 2, 0) + "." + fc.FormataCampo(String.valueOf(be.codigoEmpresa), 3, 0) + "-" + be.NomeFantasia);
            if(bcc.idBanco != 999)
                label_contaCorrenteOrigem .setText(label_contaCorrenteOrigem.getText() + "\nBanco: " + bb.codigoBanco + "-" + bb.nomeBanco + "\nAgência: " + agencia + "        Conta: " + contaCorrente);
            else
                label_contaCorrenteOrigem .setText(label_contaCorrenteOrigem.getText() + "\nBanco: Caixa");
            bd.codigoContaCorrente              = bcc.codigoContaCorrente;
        }
        if(saida.equalsIgnoreCase("D")){
            txt_codigoContaCorrenteDestino.setText(fc.FormataCampo(String.valueOf(bcc.codigoContaCorrente), 6, 0));
            label_contaCorrenteDestino.setText("Empresa: " + fc.FormataCampo(String.valueOf(be.codigoGrupo), 2, 0) + "." + fc.FormataCampo(String.valueOf(be.codigoEmpresa), 3, 0) + "-" + be.NomeFantasia);
            if(bcc.idBanco != 999)
                label_contaCorrenteDestino.setText(label_contaCorrenteDestino.getText() + "\nBanco: " + bb.codigoBanco + "-" + bb.nomeBanco + "\nAgência: " + agencia + "        Conta: " + contaCorrente);
            else
                label_contaCorrenteDestino.setText(label_contaCorrenteDestino.getText() + "\nBanco: Caixa");
            bd.codigoContaCorrenteDestino       = bcc.codigoContaCorrente;
        }
    }
    
    private void PegaEmpresa(){
        sql = "select * from ns_empresas where codigoGrupo = " + be.codigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
        dadosEmpresas.clear();
        dadosEmpresas = parametrosNS.dao.Consulta(sql);
        PegaDadosEmpresa();
    }
    
    private void PegaDadosEmpresa(){
        be.NomeEmpresa  = "----------------------------------------";
        for(int i = 0; i < dadosEmpresas.size(); i++){
            be.CodigoGrupo      = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(1)));
            be.CodigoEmpresa    = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(2)));
            be.NomeEmpresa      =                    String.valueOf(dadosEmpresas.get(i).get(4));
            be.NomeFantasia     =                    String.valueOf(dadosEmpresas.get(i).get(5));
            be.CnpjEmpresa      =                    String.valueOf(dadosEmpresas.get(i).get(6));
        }
    }
    
    private void PegaBanco(){
        sql = "select * from ns_bancos where id = " + bb.idBanco + ";";
        dadosBancos.clear();
        dadosBancos = parametrosNS.dao.Consulta(sql);
        if(dadosBancos.isEmpty()){
            return;
        }
        PegaDadosBancos();
    }
    
    private void PegaDadosBancos(){
        for(int i = 0; i < dadosBancos.size(); i++){
            bb.idBanco      = Integer.parseInt(  String.valueOf(dadosBancos.get(i).get(0)));
            bb.nomeBanco    =                    String.valueOf(dadosBancos.get(i).get(1));
            bb.codigoBanco  =                    String.valueOf(dadosBancos.get(i).get(2));
        }
    }
    
    private void PegaUsuario() {
        bu.usuario  = "----------";
        sql = "select usuario from tb_usuarios where codigoGrupo = " + bu.codigoGrupo + " and codigoEmpresa = " + bu.codigoEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuarios.clear();
        dadosUsuarios = parametrosNS.dao.Consulta(sql);
        if(dadosUsuarios.isEmpty()){
            mensagem = "Usuario " + bu.codigoUsuario + " não encontrado!";
            new MostraMensagem(mensagem);
            return;
        }
        PegaDadosUsuario();
    }
    
    private void PegaDadosUsuario(){
        for(int i = 0; i < dadosUsuarios.size(); i++)
            bu.usuario = String.valueOf(dadosUsuarios.get(i).get(0));
    }
    
    private void PegaValores(){
        bd.idEmpresa            = parametrosNS.be.IdEmpresa;
        bd.codigoGrupo          = parametrosNS.bge.CodigoGrupo;
        bd.codigoEmpresa        = parametrosNS.be.CodigoEmpresa;
        bd.codigoDespesa        = Integer.parseInt(txt_codigoDespesa.getText());
        if(check_transferencias.isSelected() == false)
            bd.transferencia    = 0;
        else
            bd.transferencia    = 1;
        bd.descricaoDespesa     = txt_descricaoDespesa.getText();
        if(bd.descricaoDespesa.equals("")){
            mensagem = "Descrição da despesa inválida!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        if(!txt_valorDespesa.getText().equals(""))
            bd.valorDespesa     = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorDespesa.getText(), 1));
        else
            bd.valorDespesa     = 0;
        bd.codigoUsuario        = parametrosNS.bu.codigoUsuario;
        bd.dataCadastro         = invdata.inverterData(cdh.CapturarData(), 2);
        bd.horaCadastro         = cdh.CapturaHora();
        bd.codigoDeBarras       = txt_codigoDeBarras.getText();
        if(!bd.codigoDeBarras.equals(""))
            bd.codigoDeBarras   = "'" + bd.codigoDeBarras + "'";
        else
            bd.codigoDeBarras   = null;
        
        bd.dataVencimento       = txt_dataVencimento.getText();
        bd.dataVencimento       = bd.dataVencimento.replace(" ", "");
        bd.dataVencimento       = bd.dataVencimento.replace("/", "");
        if(transferencias == 0){
            if(bd.dataVencimento.equals("")){
                mensagem = "Data de Vencimento inválida!";
                new MostraMensagem(mensagem);
                fatal = "S";
                return;
            }
            bd.dataVencimento       = invdata.inverterData(txt_dataVencimento.getText(), 2);
            if(check_VencimentoDiasUteis.isSelected() == false)
                bd.dataVencimento   = "'" + CalVen.CalculaDataDeVencimento(bd.dataVencimento, i, 0) + "'";
            else
                bd.dataVencimento   = "'" + CalVen.CalculaDataDeVencimento(bd.dataVencimento, i, 1) + "'";
        }else
            bd.dataVencimento   = null;
        
        if(bd.codigoContaCorrente == 0){
            mensagem = "Conta corrente de origem inválida!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        if(transferencias == 0){
            bd.codigoDespesaTipo        = bdt.codigoDespesaTipo;
            if(bd.codigoDespesaTipo == 0){
                mensagem = "Tipo de despesa inválido!";
                new MostraMensagem(mensagem);
                fatal = "S";
                return;
            }
        }else{
            bd.codigoDespesaTipo        = 0;
        }
        
        if(transferencias == 1){
            if(bd.codigoContaCorrente == 0){
                mensagem = "Conta corrente de destino inválida!";
                new MostraMensagem(mensagem);
                fatal = "S";
                return;
            }
        }else{
            bd.codigoContaCorrenteDestino   = 0;
        }
        
        bd.dataPagamento        = txt_dataPagamento.getText();
        bd.dataPagamento        = bd.dataPagamento.replace("/", "");
        bd.dataPagamento        = bd.dataPagamento.replace(" ", "");
        if(!bd.dataPagamento.equals("")){
            bd.dataPagamento    = invdata.inverterData(txt_dataPagamento.getText(), 2);
            bd.dataPagamento    = "'" + bd.dataPagamento + "'";
        }else
            bd.dataPagamento    = null;
        
        if(bd.dataPagamento != null)
            if(ValData.ValidaData(txt_dataPagamento.getText()).equals("N")){
                mensagem    = "Data de pagamento inválida!";
                new MostraMensagem(mensagem);
                fatal = "S";
                return;
            }
        
        if(!txt_valorPago.getText().equals(""))
            bd.valorPago        = Double.parseDouble(TransStrDou.TransformaValorStringeDouble(txt_valorPago.getText(), 1));
        else
            bd.valorPago        = 0;
        
        bd.idEmpresaAlterou     = parametrosNS.be.idEmpresa;
        bd.codigoGrupoAlterou   = parametrosNS.bge.codigoGrupo;
        bd.codigoEmpresaAlterou = parametrosNS.be.codigoEmpresa;
        bd.dataAlterou          = invdata.inverterData(cdh.CapturarData(), 2);
        bd.horaAlterou          = cdh.CapturaHora();
        bd.usuarioAlterou       = parametrosNS.bu.codigoUsuario;
    }
    
    private void IncluirDespesa(){
        for(i = 0; i < bd.qtdMeses; i++){
            PegaValores();
            if(fatal.equals("S"))return;
            
            sql = "insert into tb_despesas (idEmpresa, codigoGrupo, codigoEmpresa, codigoDespesa, codigoDespesaTipo, descricaoDespesa, valorDespesa, codigoUsuario, dataCadastro, horaCadastro, codigoDeBarras, qtdMeses, dataVencimento, codigoContaCorrente, dataPagamento, valorPago, transferencia) "
                + "values (" + bd.idEmpresa + ", " + bd.codigoGrupo + ", " + bd.codigoEmpresa + ", "  + bd.codigoDespesa + ", " + bd.codigoDespesaTipo + ", '" + bd.descricaoDespesa + "', " + bd.valorDespesa + ", " + bd.codigoUsuario + ", '" + bd.dataCadastro + "', '" + bd.horaCadastro + "', " + bd.codigoDeBarras + ", " + bd.qtdMeses + ", " + bd.dataVencimento + ", " + bd.codigoContaCorrente + ", " + bd.dataPagamento + ", " + bd.valorPago + ", " + bd.transferencia + ");";
            sqlstate = parametrosNS.dao.incluirRegistro(sql);
            if(!sqlstate.equals("00000")){
                i = i + 1;
                mensagem = "Erro ao incluir despesa relacionada ao mês " + i + "!";
                new MostraMensagem(mensagem);
                return;
            }
        }
        if(bd.transferencia == 0)
            mensagem = "Despesa incluida com sucesso!";
        else
            mensagem = "Transferência incluida com sucesso!";
        new MostraMensagem(mensagem);
        txt_codigoDespesa.grabFocus();
    }
    
    private void IncluirTransferencia(){
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "insert into tb_despesas (idEmpresa, codigoGrupo, codigoEmpresa, codigoDespesa, codigoDespesaTipo, descricaoDespesa, valorDespesa, codigoUsuario, dataCadastro, horaCadastro, codigoDeBarras, qtdMeses, dataVencimento, codigoContaCorrente, dataPagamento, valorPago, codigoContaCorrenteDestino, transferencia) "
            + "values (" + bd.idEmpresa + ", " + bd.codigoGrupo + ", " + bd.codigoEmpresa + ", " + bd.codigoDespesa + ", " + bd.codigoDespesaTipo + ", '" + bd.descricaoDespesa + "', " + bd.valorDespesa + ", " + bd.codigoUsuario + ", '" + bd.dataCadastro + "', '" + bd.horaCadastro + "', " + bd.codigoDeBarras + ", " + bd.qtdMeses + ", " + bd.dataVencimento + ", " + bd.codigoContaCorrente + ", " + bd.dataPagamento + ", " + bd.valorPago + ", " + bd.codigoContaCorrenteDestino + ", " + bd.transferencia + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        mensagem = "Transferência incluída com sucesso!";
        new MostraMensagem(mensagem);
        txt_codigoDespesa.grabFocus();
    }
    
}
