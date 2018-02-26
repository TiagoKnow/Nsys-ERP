package TelasProducao;

import Beans.BeanParametros;
import TelasFaturamento.ClientesConsulta;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/*
 @author Tiago e Paulo 11/06/2017 21:44:00
 */
public class RelatorioOrdensServicoGeral extends javax.swing.JFrame {
    //String's
    String sql           = "";
    String campo         = "";
    String mensagem      = "";
    String retorno       = "";
    String Texto         = "";
    String ValorTexto    = "";
    
    //int's
    int abriuOrdemServico = 0;
    int abriuCliente      = 0;
    int index             = 0;
    int statusOs1         = 0;
    int statusOs2         = 0;
    int statusOs3         = 0;
    int statusOs4         = 0;
    int statusOs5         = 0;
    
    //ArrayList's
    ArrayList<ArrayList> dadosParametros   = new ArrayList();
    
    //Bean's
    BeanParametros bpar = new BeanParametros();
    
    //Especiais
    FormataCampo     fc      = new FormataCampo();
    InverterData     invdata = new InverterData();
    CapturarDataHora cdh     = new CapturarDataHora();
    
    //Especiais para Relatórios
    String      jpv = "";
    JasperPrint jpp = null;
    HashMap     hm  = new HashMap();
    
    //Especiais
    BufferedImage BuffImg;
    ImageIcon     ImgIcon;
    Image         Img;
    

    //Telas
    OrdemServicoConsultaEManutencao OrdSerConMan;
    ClientesConsulta CliCon;
    
    public RelatorioOrdensServicoGeral() {
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_codigoOrdemServicoInicial.setText(fc.FormataCampo("", 9, 0));
        txt_codigoOrdemServicoFinal  .setText("999999999");
        txt_dataCadastroInicial .setText(fc.FormataCampo("", 8, 0));
        txt_dataCadastroFinal   .setText(cdh.CapturarData());
        txt_codigoClienteInicial.setText(fc.FormataCampo("", 5, 0));
        txt_codigoClienteFinal  .setText("99999");
        
        combo_statusPersonalizado.setVisible(false);
    }
    
    private void PegaParametros(){
        sql = "select * from tb_parametros where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametros.clear();
        dadosParametros = parametrosNS.dao.Consulta(sql);
        if(dadosParametros.isEmpty()){
            mensagem = "Pasta padrão de relatórios não encontrada!";
            mostraMensagem();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_codigoOrdemServicoInicial = new javax.swing.JFormattedTextField();
        txt_dataCadastroInicial = new javax.swing.JFormattedTextField();
        txt_codigoClienteInicial = new javax.swing.JFormattedTextField();
        txt_codigoClienteFinal = new javax.swing.JFormattedTextField();
        txt_codigoOrdemServicoFinal = new javax.swing.JFormattedTextField();
        txt_dataCadastroFinal = new javax.swing.JFormattedTextField();
        bt_pesquisaOrdemservicoInicial = new javax.swing.JButton();
        bt_pesquisaOrdemservicoFinal = new javax.swing.JButton();
        bt_pesquisaClienteInicial = new javax.swing.JButton();
        bt_pesquisaClienteFinal = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        combo_status = new javax.swing.JComboBox<>();
        combo_statusPersonalizado = new javax.swing.JComboBox<>();
        bt_imprimir = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de ordens de serviços (Geral)");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Intervalos de Pesquisa");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Ordens de Serviço:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Data de Cadastro:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cliente:");

        try {
            txt_codigoOrdemServicoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoOrdemServicoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoOrdemServicoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoOrdemServicoInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoOrdemServicoInicialFocusLost(evt);
            }
        });
        txt_codigoOrdemServicoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoOrdemServicoInicialKeyPressed(evt);
            }
        });

        try {
            txt_dataCadastroInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastroInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
            txt_codigoClienteInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoClienteInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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

        try {
            txt_codigoOrdemServicoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoOrdemServicoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoOrdemServicoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoOrdemServicoFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoOrdemServicoFinalFocusLost(evt);
            }
        });
        txt_codigoOrdemServicoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoOrdemServicoFinalKeyPressed(evt);
            }
        });

        try {
            txt_dataCadastroFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastroFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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

        bt_pesquisaOrdemservicoInicial.setText("...");
        bt_pesquisaOrdemservicoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaOrdemservicoInicialActionPerformed(evt);
            }
        });

        bt_pesquisaOrdemservicoFinal.setText("...");
        bt_pesquisaOrdemservicoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaOrdemservicoFinalActionPerformed(evt);
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

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Inicial");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Final");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Status:");

        combo_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Pendentes", "Canceladas", "Finalizadas", "Sem solução", "Faturada", "Personalizada" }));
        combo_status.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_statusItemStateChanged(evt);
            }
        });

        combo_statusPersonalizado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente e Cancelada", "Pendente e Finalizada", "Pendente e Sem Solução", "Pendente e Faturada", "Cancelada e Finalizada", "Cancelada e Sem Solução", "Cancelada e Faturada", "Finalizada e Sem Solução", "Finalizada e Faturada", "Sem solução e Faturada", "Pendente, Cancelada e Finalizada", "Pendente, Cancelada e Sem Solução", "Pendente, Cancelada e Faturada", "Pendente, Finalizada e Sem Solução", "Pendente, Finalizada e Faturada", "Pendente, Sem Solução e Faturada", "Cancelada, Finalizada e Sem Solução", "Cancelada, Finalizada e Faturada", "Cancelada, Sem Solução e Faturada", "Finalizada, Sem Solução e Faturada", "Pendente, Cancelada, Finalizada e Sem Solução", "Pendente, Cancelada, Finalizada e Faturada", "Pendente, Cancelada, Sem Solução e Faturada", "Pendente, Finalizada, Sem Solução e Faturada", "Cancelada, Finalizada, Sem Solução e Faturada" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_codigoClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_pesquisaOrdemservicoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_pesquisaClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_dataCadastroInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(txt_codigoOrdemServicoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(combo_status, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_statusPersonalizado, 0, 313, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_codigoClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_dataCadastroFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_codigoOrdemServicoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaOrdemservicoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel7});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_codigoClienteInicial, txt_codigoOrdemServicoInicial, txt_dataCadastroInicial});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel6, txt_codigoClienteFinal, txt_codigoOrdemServicoFinal, txt_dataCadastroFinal});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_pesquisaOrdemservicoFinal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_pesquisaOrdemservicoInicial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_codigoOrdemServicoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_codigoOrdemServicoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dataCadastroFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dataCadastroInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txt_codigoClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaClienteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaClienteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(combo_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_statusPersonalizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaClienteFinal, bt_pesquisaClienteInicial, bt_pesquisaOrdemservicoFinal, bt_pesquisaOrdemservicoInicial, combo_status, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, txt_codigoClienteFinal, txt_codigoClienteInicial, txt_codigoOrdemServicoFinal, txt_codigoOrdemServicoInicial, txt_dataCadastroFinal, txt_dataCadastroInicial});

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");
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
                        .addComponent(bt_imprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        InicializaCampos();
        PegaParametros();
    }//GEN-LAST:event_formWindowOpened

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        ImprimirOrdensServicos();
    }//GEN-LAST:event_bt_imprimirActionPerformed

    private void txt_codigoOrdemServicoInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrdemServicoInicialFocusGained
        txt_codigoOrdemServicoInicial.setSelectionStart(0);
        txt_codigoOrdemServicoInicial.setSelectionEnd  (txt_codigoOrdemServicoInicial.getText().length());
    }//GEN-LAST:event_txt_codigoOrdemServicoInicialFocusGained

    private void txt_codigoOrdemServicoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrdemServicoInicialFocusLost
        txt_codigoOrdemServicoInicial.setText(fc.FormataCampo(txt_codigoOrdemServicoInicial.getText(), 9, 0));
    }//GEN-LAST:event_txt_codigoOrdemServicoInicialFocusLost

    private void txt_codigoOrdemServicoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoOrdemServicoInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoOrdemServicoFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoOrdemServicoInicial.setText(fc.FormataCampo("", 8, 0));
            txt_codigoOrdemServicoFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoOrdemServicoInicialKeyPressed

    private void txt_codigoOrdemServicoFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrdemServicoFinalFocusGained
        txt_codigoOrdemServicoFinal.setSelectionStart(0);
        txt_codigoOrdemServicoFinal.setSelectionEnd  (txt_codigoOrdemServicoFinal.getText().length());
    }//GEN-LAST:event_txt_codigoOrdemServicoFinalFocusGained

    private void txt_codigoOrdemServicoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrdemServicoFinalFocusLost
        txt_codigoOrdemServicoFinal.setText(fc.FormataCampo(txt_codigoOrdemServicoFinal.getText(), 9, 0));
    }//GEN-LAST:event_txt_codigoOrdemServicoFinalFocusLost

    private void txt_codigoOrdemServicoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoOrdemServicoFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataCadastroInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoOrdemServicoFinal.setText("999999999");
            txt_dataCadastroInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoOrdemServicoFinalKeyPressed

    private void txt_dataCadastroInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroInicialFocusGained
        txt_dataCadastroInicial.setSelectionStart(0);
        txt_dataCadastroInicial.setSelectionEnd  (txt_dataCadastroInicial.getText().length());
    }//GEN-LAST:event_txt_dataCadastroInicialFocusGained

    private void txt_dataCadastroInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroInicialFocusLost
        txt_dataCadastroInicial.setText(fc.FormataCampo(txt_dataCadastroInicial.getText(), 8, 0));
    }//GEN-LAST:event_txt_dataCadastroInicialFocusLost

    private void txt_dataCadastroInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataCadastroInicialKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_dataCadastroFinal.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataCadastroInicial.setText("999999999");
            txt_dataCadastroFinal.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataCadastroInicialKeyPressed

    private void txt_dataCadastroFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroFinalFocusGained
        txt_dataCadastroFinal.setSelectionStart(0);
        txt_dataCadastroFinal.setSelectionEnd  (txt_dataCadastroFinal.getText().length());
    }//GEN-LAST:event_txt_dataCadastroFinalFocusGained

    private void txt_dataCadastroFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroFinalFocusLost
        txt_dataCadastroFinal.setText(fc.FormataCampo(txt_dataCadastroFinal.getText(), 8, 0));
    }//GEN-LAST:event_txt_dataCadastroFinalFocusLost

    private void txt_dataCadastroFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dataCadastroFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_codigoClienteInicial.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_dataCadastroFinal.setText("999999999");
            txt_codigoClienteInicial.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_dataCadastroFinalKeyPressed

    private void txt_codigoClienteInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteInicialFocusGained
        txt_codigoClienteInicial.setSelectionStart(0);
        txt_codigoClienteInicial.setSelectionEnd  (txt_codigoClienteInicial.getText().length());
    }//GEN-LAST:event_txt_codigoClienteInicialFocusGained

    private void txt_codigoClienteInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteInicialFocusLost
        txt_codigoClienteInicial.setText(fc.FormataCampo(txt_codigoClienteInicial.getText(), 8, 0));
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

    private void txt_codigoClienteFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFinalFocusGained
        txt_codigoClienteFinal.setSelectionStart(0);
        txt_codigoClienteFinal.setSelectionEnd  (txt_codigoClienteFinal.getText().length());
    }//GEN-LAST:event_txt_codigoClienteFinalFocusGained

    private void txt_codigoClienteFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFinalFocusLost
        txt_codigoClienteFinal.setText(fc.FormataCampo(txt_codigoClienteFinal.getText(), 8, 0));
    }//GEN-LAST:event_txt_codigoClienteFinalFocusLost

    private void txt_codigoClienteFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoClienteFinalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            bt_imprimir.grabFocus();
            return;
        }
        if(evt.getKeyCode() == KeyEvent.VK_F11){
            txt_codigoClienteFinal.setText("99999");
            bt_imprimir.grabFocus();
            return;
        }
    }//GEN-LAST:event_txt_codigoClienteFinalKeyPressed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_pesquisaOrdemservicoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaOrdemservicoInicialActionPerformed
        campo = "I";
        PesquisaOrdemServico();
    }//GEN-LAST:event_bt_pesquisaOrdemservicoInicialActionPerformed
    
    private void PesquisaOrdemServico(){
        if(OrdSerConMan != null)if(OrdSerConMan.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuOrdemServico = 1;
        OrdSerConMan = new OrdemServicoConsultaEManutencao("N", "N");
        OrdSerConMan.setVisible(true);
    }
    
    private void bt_pesquisaOrdemservicoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaOrdemservicoFinalActionPerformed
        campo = "F";
        PesquisaOrdemServico();
    }//GEN-LAST:event_bt_pesquisaOrdemservicoFinalActionPerformed

    private void bt_pesquisaClienteInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteInicialActionPerformed
        campo = "I";
        PesquisaCliente();
    }//GEN-LAST:event_bt_pesquisaClienteInicialActionPerformed
    
    private void PesquisaCliente(){
        if(CliCon != null)if(CliCon.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        abriuCliente = 1;
        CliCon = new ClientesConsulta("N");
        CliCon.setVisible(true);
    }
    
    private void bt_pesquisaClienteFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaClienteFinalActionPerformed
        campo = "F";
        PesquisaCliente();
    }//GEN-LAST:event_bt_pesquisaClienteFinalActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuOrdemServico == 0){
            AbrePesquisaCliente();
            return;
        }
        abriuOrdemServico = 0;
        retorno = OrdSerConMan.getRetorno();
        if(retorno.equals(""))
            return;
        if(campo.equals("I")){
            txt_codigoOrdemServicoInicial.setText(fc.FormataCampo(retorno, 9, 0));
            return;
        }
        txt_codigoOrdemServicoFinal.setText(fc.FormataCampo(retorno, 9, 0));
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbrePesquisaCliente(){
        if(abriuCliente == 0)
            return;
        abriuCliente = 0;
        retorno = CliCon.getRetorno();
        if(retorno.equals(""))
            return;
        if(campo.equals("I")){
            txt_codigoClienteInicial.setText(fc.FormataCampo(retorno, 5, 0));
            return;
        }
        txt_codigoClienteFinal.setText(fc.FormataCampo(retorno, 5, 0));
    }
    
    private void combo_statusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_statusItemStateChanged
        if(combo_status.getSelectedIndex() < 6)
            combo_statusPersonalizado.setVisible(false);
        else
            combo_statusPersonalizado.setVisible(true);
    }//GEN-LAST:event_combo_statusItemStateChanged
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_pesquisaClienteFinal;
    private javax.swing.JButton bt_pesquisaClienteInicial;
    private javax.swing.JButton bt_pesquisaOrdemservicoFinal;
    private javax.swing.JButton bt_pesquisaOrdemservicoInicial;
    private javax.swing.JButton bt_sair;
    private javax.swing.JComboBox<String> combo_status;
    private javax.swing.JComboBox<String> combo_statusPersonalizado;
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
    private javax.swing.JFormattedTextField txt_codigoClienteFinal;
    private javax.swing.JFormattedTextField txt_codigoClienteInicial;
    private javax.swing.JFormattedTextField txt_codigoOrdemServicoFinal;
    private javax.swing.JFormattedTextField txt_codigoOrdemServicoInicial;
    private javax.swing.JFormattedTextField txt_dataCadastroFinal;
    private javax.swing.JFormattedTextField txt_dataCadastroInicial;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void ImprimirOrdensServicos(){
        ValorTexto = "";
        index = combo_status.getSelectedIndex();
        Texto = String.valueOf(combo_statusPersonalizado.getSelectedItem()) + " ";
        statusOs1 = -1;
        statusOs2 = -1;
        statusOs3 = -1;
        statusOs4 = -1;
        statusOs5 = -1;
        if(index == 0){ 
            statusOs1 = 0;  //0 - Pendente
            statusOs2 = 1;  //1 - Cancelada
            statusOs3 = 2;  //2 - Finalizada
            statusOs4 = 3;  //3 - Sem solução
            statusOs5 = 4;  //4 - Faturada
        }
        if(index == 1){
            statusOs1 = 0;  //0 - Pendente
            statusOs2 = 0;  //0 - Pendente
            statusOs3 = 0;  //0 - Pendente
            statusOs4 = 0;  //0 - Pendente
            statusOs5 = 0;  //0 - Pendente
        }
        if(index == 2){
            statusOs1 = 1;  //1 - Cancelada
            statusOs2 = 1;  //1 - Cancelada
            statusOs3 = 1;  //1 - Cancelada
            statusOs4 = 1;  //1 - Cancelada
            statusOs5 = 1;  //1 - Cancelada
        }
        if(index == 3){
            statusOs1 = 2;  //2 - Finalizada
            statusOs2 = 2;  //2 - Finalizada
            statusOs3 = 2;  //2 - Finalizada
            statusOs4 = 2;  //2 - Finalizada
            statusOs5 = 2;  //2 - Finalizada
        }
        if(index == 4){
            statusOs1 = 3;  //3 - Sem solução
            statusOs2 = 3;  //3 - Sem solução
            statusOs3 = 3;  //3 - Sem solução
            statusOs4 = 3;  //3 - Sem solução
            statusOs5 = 3;  //3 - Sem solução
        }
        if(index == 5){
            statusOs1 = 4;  //4 - Faturada
            statusOs2 = 4;  //4 - Faturada
            statusOs3 = 4;  //4 - Faturada
            statusOs4 = 4;  //4 - Faturada
            statusOs5 = 4;  //4 - Faturada
        }
        if(index == 6){
            for(int i = 0; i < Texto.length() - 8; i++){
                ValorTexto = Texto.substring(i, i + 8);
                if(ValorTexto.equalsIgnoreCase("Pendente")){
                    statusOs1 = 0;
                    if(statusOs2 != 1)
                        statusOs2 = statusOs1;
                    if(statusOs3 != 2)
                        statusOs3 = statusOs1;
                    if(statusOs4 != 3)
                        statusOs4 = statusOs1;
                    if(statusOs5 != 4)
                        statusOs5 = statusOs1;
                    break;
                }
            }
            for(int i = 0; i < Texto.length() - 9; i++){
                ValorTexto = Texto.substring(i, i + 9);
                if(ValorTexto.equalsIgnoreCase("Cancelada")){
                    statusOs2 = 1;
                    if(statusOs1 != 0)
                        statusOs1 = statusOs2;
                    if(statusOs3 != 2)
                        statusOs3 = statusOs2;
                    if(statusOs4 != 3)
                        statusOs4 = statusOs2;
                    if(statusOs5 != 4)
                        statusOs5 = statusOs2;
                    break;
                }
            }
            for(int i = 0; i < Texto.length() - 10; i++){
                ValorTexto = Texto.substring(i, i + 10);
                if(ValorTexto.equalsIgnoreCase("Finalizada")){
                    statusOs3 = 2;
                    if(statusOs1 != 0)
                        statusOs1 = statusOs3;
                    if(statusOs2 != 1)
                        statusOs2 = statusOs3;
                    if(statusOs4 != 3)
                        statusOs4 = statusOs3;
                    if(statusOs5 != 4)
                        statusOs5 = statusOs3;
                    break;
                }
            }
            for(int i = 0; i < Texto.length() - 11; i++){
                ValorTexto = Texto.substring(i, i + 11);
                if(ValorTexto.equalsIgnoreCase("Sem Solução")){
                    statusOs4 = 3;
                    if(statusOs1 != 0)
                        statusOs1 = statusOs4;
                    if(statusOs2 != 1)
                        statusOs2 = statusOs4;
                    if(statusOs3 != 2)
                        statusOs3 = statusOs4;
                    if(statusOs5 != 4)
                        statusOs5 = statusOs4;
                    break;
                }
            }
            for(int i = 0; i < Texto.length() - 8; i++){
                ValorTexto = Texto.substring(i, i + 8);
                if(ValorTexto.equalsIgnoreCase("Faturada")){
                    statusOs5 = 4;
                    if(statusOs1 != 0)
                        statusOs1 = statusOs5;
                    if(statusOs2 != 1)
                        statusOs2 = statusOs5;
                    if(statusOs3 != 2)
                        statusOs3 = statusOs5;
                    if(statusOs4 != 3)
                        statusOs4 = statusOs5;
                    break;
                }
            }
        }
        
        try{
            if(parametrosNS.be.imagemLogotipoEmpresa != null){
                BuffImg = ImageIO.read(new ByteArrayInputStream(parametrosNS.be.imagemLogotipoEmpresa));
                ImgIcon = new ImageIcon(BuffImg);
                Img     = ImgIcon.getImage();
            }
            
            hm.clear();
            hm.put("idEmpresa"      , parametrosNS.be.IdEmpresa);
            hm.put("nomeEmpresa"    , parametrosNS.be.NomeEmpresa);
            hm.put("cnpjEmpresa"    , parametrosNS.be.CnpjEmpresa);
            hm.put("cidadeEmpresa"  , parametrosNS.be.CidadeEmpresa + ", " + parametrosNS.be.UfEmpresa);
            hm.put("enderecoEmpresa", parametrosNS.be.EnderecoEmpresa + ", " + parametrosNS.be.NumeroEmpresa + ", " + parametrosNS.be.bairroEmpresa);
            hm.put("cepEmpresa"     , parametrosNS.be.CepEmpresa);
            hm.put("telefoneEmpresa", parametrosNS.be.TelefoneEmpresa);
            
            if(parametrosNS.be.imagemLogotipoEmpresa != null)
                hm.put("logotipoEmpresa", Img);
            else
                hm.put("logotipoEmpresa", null);
            
            hm.put("osInicial"           , Integer.parseInt(txt_codigoOrdemServicoInicial.getText()));
            hm.put("osFinal"             , Integer.parseInt(txt_codigoOrdemServicoFinal  .getText()));
            hm.put("dataCadastroInicial" , invdata.inverterData(txt_dataCadastroInicial.getText(), 2));
            hm.put("dataCadastroFinal"   , invdata.inverterData(txt_dataCadastroFinal  .getText(), 2));
            hm.put("codigoClienteInicial", Integer.parseInt(txt_codigoClienteInicial.getText()));
            hm.put("codigoClienteFinal"  , Integer.parseInt(txt_codigoClienteFinal  .getText()));
            hm.put("statusOs1"           , statusOs1);
            hm.put("statusOs2"           , statusOs2);
            hm.put("statusOs3"           , statusOs3);
            hm.put("statusOs4"           , statusOs4);
            hm.put("statusOs5"           , statusOs5);
            
//            System.out.println("\nstatusOs1 - " + statusOs1 + "\nstatusOs2 - " + statusOs2 + "\nstatusOs3 - " + statusOs3 + "\nstatusOs4 - " + statusOs4 + "\nstatusOs5 - " + statusOs5);
            
            jpv     = "Relatorios/RelatorioDeOrdensServicos.jasper";
            
            jpp     = JasperFillManager.fillReport(jpv, hm, parametrosNS.con);
            JasperViewer.viewReport(jpp, false);
        }catch(Exception erro){
            mensagem = "Erro ao imprimir: " + erro.getMessage();
            mostraMensagem();
        }
    }
    
}
