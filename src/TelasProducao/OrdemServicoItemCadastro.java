package TelasProducao;

import Beans.*;
import FuncoesInternas.InverterData;
import FuncoesInternas.*;
import TelasEstoque.*;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.text.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/*
 @author Tiago e Paulo
 */
public class OrdemServicoItemCadastro extends javax.swing.JFrame {
    //String's
    String sql            = "";
    String mensagem       = "";
    String converte       = "";
    String valorFormatado = "";
    String somostra       = "";
    String retorno        = "";
    String operacao       = "";
    String sqlstate       = "";
    String fatal          = "";
    
    //int's
    int    ultimoRegistroItem = 0;
    int    abriuServico       = 0;
    int    abriuProduto       = 0;
    
    //Vetores
    ArrayList            parametros             = new ArrayList();
    ArrayList            dadosPadroes           = new ArrayList();
    ArrayList<ArrayList> dadosCliente           = new ArrayList();
    ArrayList<ArrayList> dadosCount             = new ArrayList();
    ArrayList<ArrayList> dadosOrdemServico      = new ArrayList();
    ArrayList<ArrayList> dadosOrdemServicoItens = new ArrayList();
    ArrayList<ArrayList> dadosProdutos          = new ArrayList();
    ArrayList<ArrayList> dadosServicos          = new ArrayList();
    ArrayList<ArrayList> dadosUsuarios          = new ArrayList();
    
    //Bean's
    BeanUsuarios            bu          = new BeanUsuarios();
    BeanClientes            bc          = new BeanClientes();
    BeanOrdemServico        bos         = new BeanOrdemServico();
    BeanOrdemServicoItens   bosi        = new BeanOrdemServicoItens();
    BeanProdutos            bp          = new BeanProdutos();
    BeanServicos            bser        = new BeanServicos();
    
    //Double's
    double Quantidade                   = 0;
    
    //Telas
    ServicoConsulta     SerCon;
    ProdutosConsulta    ProCon;
    
    public OrdemServicoItemCadastro(ArrayList DadosPadroes){
        dadosPadroes = DadosPadroes;
        
        somostra                    = (String)  dadosPadroes.get(0);
        operacao                    = (String)  dadosPadroes.get(1);
        bosi.codigoOrdemServico     = (int)     dadosPadroes.get(2);
        bosi.codigoOrdemServicoItem = (int)     dadosPadroes.get(3);
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_codigoOrdemServico = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        txt_codigoOrdemServicoItem = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        label_nomeUsuario = new javax.swing.JLabel();
        txt_codigoUsuario = new javax.swing.JFormattedTextField();
        txt_dataCadastro = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_horaCadastro = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_codigoCliente = new javax.swing.JFormattedTextField();
        label_nomeCliente = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_codigoServicoProduto = new javax.swing.JFormattedTextField();
        bt_pesquisaCodigo = new javax.swing.JButton();
        label_descricao = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_valorUnitario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_quantidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_valorTotal = new javax.swing.JTextField();
        bt_alterar = new javax.swing.JButton();
        bt_incluir = new javax.swing.JButton();
        bt_imprimirOrdemServico = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        combo_tipo = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        label_alteracao = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jLabel1.setText("Ordem de Serviço");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_codigoOrdemServico.setEditable(false);
        try {
            txt_codigoOrdemServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoOrdemServico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoOrdemServico.setFocusable(false);
        txt_codigoOrdemServico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoOrdemServicoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoOrdemServicoFocusLost(evt);
            }
        });

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        try {
            txt_codigoOrdemServicoItem.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoOrdemServicoItem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoOrdemServicoItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoOrdemServicoItemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoOrdemServicoItemFocusLost(evt);
            }
        });
        txt_codigoOrdemServicoItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoOrdemServicoItemKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoOrdemServico, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_codigoOrdemServicoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_codigoOrdemServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoOrdemServicoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, txt_codigoOrdemServico, txt_codigoOrdemServicoItem});

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Informações");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoUsuario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuario.setEditable(false);
        try {
            txt_codigoUsuario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoUsuario.setFocusable(false);
        txt_codigoUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoUsuarioFocusLost(evt);
            }
        });
        txt_codigoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoUsuarioActionPerformed(evt);
            }
        });

        txt_dataCadastro.setEditable(false);
        try {
            txt_dataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataCadastro.setEnabled(false);
        txt_dataCadastro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataCadastroFocusLost(evt);
            }
        });
        txt_dataCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dataCadastroActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Digitado por:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Data do Cadastro:");

        txt_horaCadastro.setEditable(false);
        try {
            txt_horaCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_horaCadastro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_horaCadastro.setFocusable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_codigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_horaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_codigoUsuario)
                            .addComponent(label_nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_horaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel4, jLabel5, txt_codigoUsuario, txt_dataCadastro});

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
        txt_codigoCliente.setFocusable(false);
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

        label_nomeCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_nomeClienteMouseEntered(evt);
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
                .addComponent(label_nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Itens");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Código: ");

        try {
            txt_codigoServicoProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoServicoProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoServicoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoServicoProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoServicoProdutoFocusLost(evt);
            }
        });
        txt_codigoServicoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoServicoProdutoActionPerformed(evt);
            }
        });
        txt_codigoServicoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoServicoProdutoKeyPressed(evt);
            }
        });

        bt_pesquisaCodigo.setText("...");
        bt_pesquisaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaCodigoActionPerformed(evt);
            }
        });

        label_descricao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Valor unitário: ");

        txt_valorUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorUnitarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorUnitarioFocusLost(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Quantidade: ");

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

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Valor total: ");

        txt_valorTotal.setEditable(false);
        txt_valorTotal.setFocusable(false);
        txt_valorTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_valorTotalKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_valorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_valorTotal))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_codigoServicoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(bt_pesquisaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_codigoServicoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label_descricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_valorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(txt_valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel8, jLabel9, txt_quantidade, txt_valorTotal, txt_valorUnitario});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaCodigo, jLabel6, label_descricao, txt_codigoServicoProduto});

        bt_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Save.png"))); // NOI18N
        bt_alterar.setText("Alterar");
        bt_alterar.setEnabled(false);
        bt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarActionPerformed(evt);
            }
        });
        bt_alterar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_alterarKeyPressed(evt);
            }
        });

        bt_incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_incluir.setText("Incluir");
        bt_incluir.setEnabled(false);
        bt_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirActionPerformed(evt);
            }
        });
        bt_incluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_incluirKeyPressed(evt);
            }
        });

        bt_imprimirOrdemServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        bt_imprimirOrdemServico.setText("Imprimir OS");
        bt_imprimirOrdemServico.setEnabled(false);
        bt_imprimirOrdemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirOrdemServicoActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Tipo");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        combo_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------", "Produto", "Serviço" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_tipo)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_alteracao.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
        );

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_imprimirOrdemServico)
                        .addContainerGap())))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_alterar, bt_incluir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_imprimirOrdemServico, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel2, jPanel6});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_alterar, bt_incluir});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoOrdemServicoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrdemServicoFocusGained
        
    }//GEN-LAST:event_txt_codigoOrdemServicoFocusGained

    private void txt_codigoOrdemServicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrdemServicoFocusLost
        
    }//GEN-LAST:event_txt_codigoOrdemServicoFocusLost

    private void txt_dataCadastroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dataCadastroFocusLost

    private void txt_dataCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dataCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dataCadastroActionPerformed

    private void txt_codigoUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioFocusLost

    }//GEN-LAST:event_txt_codigoUsuarioFocusLost

    private void txt_codigoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoUsuarioActionPerformed

    private void txt_codigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoClienteFocusLost
        
    }//GEN-LAST:event_txt_codigoClienteFocusLost

    private void txt_codigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoClienteActionPerformed
        
    }//GEN-LAST:event_txt_codigoClienteActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        AlteraRegistro();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        IncluirRegistro();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_imprimirOrdemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirOrdemServicoActionPerformed
//        PegaOrdemServico();
//        if(fatal.equals("S"))return;
//        PegaDadosOrdemServico();
//        txt_codigoCliente.setText(String.valueOf(bos.codigoCliente));
//        PegaCliente();
//        PegaDadosCliente();
//        sql = "select * from tb_os where codigoOrdemServico = '" + bos.codigoOrdemServico + "';";
//        try{
//            stmt = con.prepareStatement(sql);
//            rs   = stmt.executeQuery();
//            js   = new JRResultSetDataSource(rs);
//
//            hm.put("nomeEmpresa", parametrosNS.be.nomeEmpresa);
//            hm.put("enderecoEmpresa", parametrosNS.be.enderecoEmpresa + ", " + parametrosNS.be.numeroEmpresa);
//            hm.put("telefoneEmpresa", parametrosNS.be.telefoneEmpresa);
//            hm.put("cnpjEmpresa", FCpfCnpj.FormataCPFCNPJ(parametrosNS.be.cnpjEmpresa));
//            hm.put("emailSiteEmpresa", "");
//            hm.put("codigoOrdemServico", bos.codigoOrdemServico);
//            hm.put("nomeCliente", bc.nome);
//            hm.put("enderecoCliente", bc.endereco);
//            hm.put("bairroCliente", bc.bairro);
//            hm.put("cidadeCliente", bc.cidade);
//            hm.put("ufCliente", bc.uf);
//            hm.put("cepCliente", bc.cep);
//            hm.put("logotipoEmpresa", bpar.pastaLogotipo + "/LOGOTIPO." + bpar.extensaoLogotipo);
//
//            jpv = bpar.pastaRelatorios + "/RelatorioOS.jasper";
//
//            jpp = JasperFillManager.fillReport(jpv, hm, js);
//            JasperViewer.viewReport(jpp, false);
//        }catch(Exception erro){
//            mensagem = "Erro ao imprimir: " + erro.getMessage();
//            mostraMensagem();
//        }
    }//GEN-LAST:event_bt_imprimirOrdemServicoActionPerformed

    private void bt_pesquisaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaCodigoActionPerformed
        switch(combo_tipo.getSelectedIndex()){
            case  1: AbreConsultaProduto(); break;
            case  2: AbreConsultaServico(); break;
            default: mensagem = "Tipo de Item não selecionado!";mostraMensagem();
        }
    }//GEN-LAST:event_bt_pesquisaCodigoActionPerformed

    private void txt_codigoOrdemServicoItemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrdemServicoItemFocusLost
        if(txt_codigoOrdemServicoItem.getText().replace(" ", "").equals(""))
            return;
        if(somostra.equals("S"))
            return;
        if(operacao.equals("I"))
            return;
        PegaOrdemServicoItem();
    }//GEN-LAST:event_txt_codigoOrdemServicoItemFocusLost
    
    private void CalculaValores(){
        bosi.valorUnitario  = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorUnitario.getText(), 1));
        bosi.quantidade     = Double.parseDouble(txt_quantidade.getText());
        bosi.valorTotal     = bosi.valorUnitario * bosi.quantidade;
        txt_valorTotal.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bosi.valorTotal), 0));
    }
    
    private void txt_codigoOrdemServicoItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoOrdemServicoItemKeyPressed
        if(txt_codigoOrdemServicoItem.getText().replace(" ", "").equals(""))
            return;
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        CalculaValores();
    }//GEN-LAST:event_txt_codigoOrdemServicoItemKeyPressed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        NovoRegistro();
    }//GEN-LAST:event_bt_novoActionPerformed
    
    private void NovoRegistro(){
        combo_tipo.grabFocus();
        ReiniciaCampos();
        HabilitaCampos(true);
        
        operacao = "I";
        HabilitaBotoes();
        
        VerificaUltimoRegistro();
        bosi.codigoOrdemServicoItem = ultimoRegistroItem + 1;
        txt_codigoOrdemServicoItem.setText(parametrosNS.fc.FormataCampo(String.valueOf(bosi.codigoOrdemServicoItem), 2, 0));
    }
    
    private void AlterarRegistro(){
        bt_novo.setEnabled  (false);
        bt_novo.setFocusable(false);
        txt_codigoOrdemServicoItem.setEnabled  (false);
        txt_codigoOrdemServicoItem.setFocusable(false);
        txt_codigoOrdemServicoItem.setText(String.valueOf(bosi.codigoOrdemServicoItem));
        PegaOrdemServicoItem();
    }
    
    private void VerificaUltimoRegistro(){
        sql = "select count(*) from tb_os_itens where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoOrdemServico = " + bosi.codigoOrdemServico + ";";
        dadosCount.clear();
        dadosCount = parametrosNS.dao.Consulta(sql);
        ultimoRegistroItem = Integer.parseInt(  String.valueOf(dadosCount.get(0).get(0)));
    }
    
    private void txt_codigoOrdemServicoItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOrdemServicoItemFocusGained
        txt_codigoOrdemServicoItem.setSelectionStart(0);
        txt_codigoOrdemServicoItem.setSelectionEnd  (txt_codigoOrdemServicoItem.getText().length());
    }//GEN-LAST:event_txt_codigoOrdemServicoItemFocusGained

    private void txt_codigoServicoProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoServicoProdutoFocusGained
        ReiniciaCampos();
    }//GEN-LAST:event_txt_codigoServicoProdutoFocusGained

    private void txt_codigoServicoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoServicoProdutoFocusLost
        if(!txt_codigoServicoProduto.getText().replace(" ", "").equals("")){
            VerificaTipoItemOrdemServico();
        }
    }//GEN-LAST:event_txt_codigoServicoProdutoFocusLost

    private void txt_codigoServicoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoServicoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoServicoProdutoActionPerformed

    private void txt_codigoServicoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoServicoProdutoKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_quantidade.grabFocus();
    }//GEN-LAST:event_txt_codigoServicoProdutoKeyPressed

    private void txt_quantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantidadeFocusLost
        if(txt_quantidade.getText().equals(""))
            return;
        try{
            CalculaValores();
        }catch(Exception erro){
            mensagem = "Erro ao calcular valor total!";
            mostraMensagem();
        }
    }//GEN-LAST:event_txt_quantidadeFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuServico == 0){
            AbriuConsultaProduto();
            return;
        }
        retorno = SerCon.getRetorno();
        if(retorno.equals("")){
            return;
        }
        abriuServico = 0;
        txt_codigoServicoProduto.setText(retorno);
        PegaServicos();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbriuConsultaProduto(){
        if(abriuProduto == 0){
            return;
        }
        abriuProduto = 0;
        retorno = ProCon.getRetorno();
        if(retorno.equals("")){
            return;
        }
        txt_codigoServicoProduto.setText(parametrosNS.fc.FormataCampo(retorno, 6, 0));
        bp.codigoProduto = Integer.parseInt(txt_codigoServicoProduto.getText());
        PegaProdutos();
    }
    
    private void txt_quantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_quantidadeKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        if(operacao.equals("I"))
            bt_incluir.grabFocus();
        else
            bt_alterar.grabFocus();
    }//GEN-LAST:event_txt_quantidadeKeyPressed

    private void label_nomeClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_nomeClienteMouseEntered
        label_nomeCliente.setToolTipText(label_nomeCliente.getText());
    }//GEN-LAST:event_label_nomeClienteMouseEntered

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txt_codigoOrdemServico  .setText(parametrosNS.fc.FormataCampo(String.valueOf(bos.codigoOrdemServico), 9, 0));
        txt_dataCadastro      .setText(parametrosNS.cdh.CapturarData());
        
        PegaOrdemServico();
        if(operacao.equals("I")){NovoRegistro();}else{AlterarRegistro();}
        if(somostra.equals("S")){
            bt_incluir                  .setVisible (false);
            bt_alterar                  .setVisible (false);
            txt_codigoOrdemServicoItem  .setEditable(false);
            bt_novo                     .setEnabled (false);
            bt_pesquisaCodigo           .setEnabled (false);
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(SerCon   != null)SerCon.dispose();
        if(ProCon   != null)ProCon.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void txt_valorTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorTotalKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            if(operacao.equals("I"))
                bt_incluir.grabFocus();
            else
                bt_alterar.grabFocus();
    }//GEN-LAST:event_txt_valorTotalKeyPressed

    private void bt_incluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_incluirKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        IncluirRegistro();
    }//GEN-LAST:event_bt_incluirKeyPressed

    private void bt_alterarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_alterarKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        AlterarRegistro();
    }//GEN-LAST:event_bt_alterarKeyPressed

    private void txt_valorUnitarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorUnitarioFocusGained
        if(txt_valorUnitario.isEditable() == false)
            return;
        if(!txt_valorUnitario.getText().equals(""))
            txt_valorUnitario.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorUnitario.getText(), 1));
    }//GEN-LAST:event_txt_valorUnitarioFocusGained

    private void txt_valorUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorUnitarioFocusLost
        if(txt_valorUnitario.isEditable() == false)
            return;
        if(!txt_valorUnitario.getText().equals(""))
            txt_valorUnitario.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorUnitario.getText(), 0));
    }//GEN-LAST:event_txt_valorUnitarioFocusLost
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_imprimirOrdemServico;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisaCodigo;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JComboBox combo_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel label_alteracao;
    private javax.swing.JLabel label_descricao;
    private javax.swing.JLabel label_nomeCliente;
    private javax.swing.JLabel label_nomeUsuario;
    private javax.swing.JFormattedTextField txt_codigoCliente;
    private javax.swing.JFormattedTextField txt_codigoOrdemServico;
    private javax.swing.JFormattedTextField txt_codigoOrdemServicoItem;
    private javax.swing.JFormattedTextField txt_codigoServicoProduto;
    private javax.swing.JFormattedTextField txt_codigoUsuario;
    private javax.swing.JFormattedTextField txt_dataCadastro;
    private javax.swing.JFormattedTextField txt_horaCadastro;
    private javax.swing.JTextField txt_quantidade;
    private javax.swing.JTextField txt_valorTotal;
    private javax.swing.JTextField txt_valorUnitario;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void ReiniciaCampos(){
        txt_codigoServicoProduto.setText("");
        label_descricao         .setText("");
        txt_valorUnitario       .setText("");
        txt_quantidade          .setText("");
        txt_valorTotal          .setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        combo_tipo                  .setEnabled     (Habilita);
        combo_tipo                  .setFocusable   (Habilita);
        txt_codigoServicoProduto    .setEditable    (Habilita);
        txt_codigoServicoProduto    .setFocusable   (Habilita);
        bt_pesquisaCodigo           .setEnabled     (Habilita);
        bt_pesquisaCodigo           .setFocusable   (Habilita);
//        txt_valorUnitario           .setEditable    (Habilita);
//        txt_valorUnitario           .setFocusable   (Habilita);
        txt_quantidade              .setEditable    (Habilita);
        txt_quantidade              .setFocusable   (Habilita);
//        txt_valorTotal              .setEditable    (Habilita);
//        txt_valorTotal              .setFocusable   (Habilita);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir.setEnabled(true);
            bt_alterar.setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(true);
            return;
        }
        bt_incluir.setEnabled(false);
        bt_alterar.setEnabled(false);
    }
    
    private void IncluirRegistro(){
        PegaValores();
        if(fatal.equals("S")){
            return;
        }
        sql = "insert into tb_os_itens (idEmpresa, codigoGrupo, codigoEmpresa, codigoOrdemServico, codigoOrdemServicoItem, codigoServicoProduto, dataCadastro, horaCadastro, codigoUsuario, tipo, valorUnitario, quantidade, valorTotal, codigoServico, codigoProduto) "
            + "values (" + bosi.idEmpresa + ", " + bosi.codigoGrupo + ", " + bosi.codigoEmpresa + ", " + bosi.codigoOrdemServico + ", " + bosi.codigoOrdemServicoItem + ", " + bosi.codigoServicoProduto + ", '" + bosi.dataCadastro + "', '" + bosi.horaCadastro + "', " + bosi.codigoUsuario + ", " + bosi.tipo + ", " + bosi.valorUnitario + ", " + bosi.quantidade + ", " + bosi.valorTotal + ", " + bosi.codigoServico + ", " + bosi.codigoProduto + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir registro!";
            mostraMensagem();
            return;
        }
        AtualizaEstoque();
        if(fatal.equals("S"))
            return;
        mensagem = "Registro incluído com sucesso!";
        mostraMensagem();
        NovoRegistro();
    }
    
    private void AlteraRegistro(){
        AtualizaEstoque();
        if(fatal.equals("S")){return;}
        PegaValores();
        if(fatal.equals("S")){return;}
        sql = "update tb_os_itens set codigoServicoProduto =  "         + bosi.codigoServicoProduto     + ", " +
                                     "tipo = "                          + bosi.tipo                     + ", " +
                                     "valorUnitario = "                 + bosi.valorUnitario            + ", " +
                                     "quantidade = "                    + bosi.quantidade               + ", " +
                                     "valorTotal = "                    + bosi.valorTotal               + ", " +
                                     "codigoServico = "                 + bosi.codigoServico            + ", " +
                                     "codigoProduto = "                 + bosi.codigoProduto            + ", " +
                                     "idEmpresaAlterou = "              + bosi.idEmpresaAlterou         + ", " +
                                     "codigoGrupoAlterou = "            + bosi.codigoGrupoAlterou       + ", " +
                                     "codigoEmpresaAlterou = "          + bosi.codigoEmpresaAlterou     + ", " +
                                     "dataAlterou = '"                  + bosi.dataAlterou              + "', " +
                                     "horaAlterou = '"                  + bosi.horaAlterou              + "', " +
                                     "usuarioAlterou = "                + bosi.usuarioAlterou           + " " +
                                     "where idOrdemServicoItem = "      + bosi.idOrdemServicoItem       + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000")){
            return;
        }
        operacao = "I";
        AtualizaEstoque();
        dispose();
    }
    
    private void AtualizaEstoque(){
        if(bosi.tipo != 1)
            return;
        bp.codigoProduto    = bosi.codigoServicoProduto;
        PegaProdutos();
        if(fatal.equals("S"))return;
        PegaDadosProdutos();
        if(operacao.equals("I")){
            bp.quantidadeAtual = bp.quantidadeAtual - bosi.quantidade;
        }else{
            bp.quantidadeAtual = bp.quantidadeAtual + bosi.quantidade;
        }
        
        sql = "update tb_produtos set quantidadeAtual = " + bp.quantidadeAtual + " where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(sqlstate.equals("00000"))
            return;
        mensagem = "Erro ao atualizar estoque do produto n°" + bp.codigoProduto + "!";
        mostraMensagem();
        fatal = "S";
    }
    
    private void PegaOrdemServico(){
        bos.idEmpresa           = parametrosNS.be.IdEmpresa;
        bos.codigoGrupo         = parametrosNS.bge.CodigoGrupo;
        bos.codigoEmpresa       = parametrosNS.be.CodigoEmpresa;
        bos.codigoOrdemServico  = bosi.codigoOrdemServico;
        sql = "select \n"
            + "   idOrdemServico, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoOrdemServico, \n"
            + "   codigoCliente \n"
            + "from tb_os where idEmpresa = " + bos.idEmpresa + " and codigoOrdemServico = " + bos.codigoOrdemServico + ";";
        dadosOrdemServico.clear();
        dadosOrdemServico = parametrosNS.dao.Consulta(sql);
        if(dadosOrdemServico.isEmpty()){
            mensagem = "Ordem de serviço não encontrada!";
            mostraMensagem();
            dispose();
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
        }
        txt_codigoOrdemServico.setText(parametrosNS.fc.FormataCampo(String.valueOf(bos.codigoOrdemServico), 9, 0));
        
        bc.codigoCliente    = bos.codigoCliente;
        PegaCliente();
    }
    
    private void PegaOrdemServicoItem(){
        bosi.idEmpresa          = bos.idEmpresa;
        bosi.codigoGrupo        = bos.codigoGrupo;
        bosi.codigoEmpresa      = bos.codigoEmpresa;
        bosi.codigoOrdemServico = bos.codigoOrdemServico;
        bosi.codigoOrdemServicoItem = Integer.parseInt(txt_codigoOrdemServicoItem.getText().replace(" ", ""));
        if(bosi.codigoOrdemServicoItem == 0)
            return;
        sql = "select \n"
            + "   idOrdemServicoItem, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoOrdemServico, \n"
            + "   codigoOrdemServicoItem, \n"
            + "   codigoUsuario, \n"
            + "   dataCadastro, \n"
            + "   horaCadastro, \n"
            + "   tipo, \n"
            + "   valorUnitario, \n"
            + "   quantidade, \n"
            + "   valorTotal, \n"
            + "   dataAlterou, \n"
            + "   horaAlterou, \n"
            + "   usuarioAlterou, \n"
            + "   idEmpresaAlterou, \n"
            + "   codigoGrupoAlterou, \n"
            + "   codigoEmpresaAlterou, \n"
            + "   codigoServico, \n"
            + "   codigoProduto \n"
            + " from tb_os_itens where idEmpresa = " + bosi.idEmpresa + " and codigoOrdemServico = " + bosi.codigoOrdemServico + " and codigoOrdemServicoItem = " + bosi.codigoOrdemServicoItem + ";";
        dadosOrdemServicoItens.clear();
        dadosOrdemServicoItens = parametrosNS.dao.Consulta(sql);
        if(dadosOrdemServicoItens.isEmpty()){
            mensagem = "Item " + bosi.codigoOrdemServicoItem + " não encontrado para a OS n°" + bos.codigoOrdemServico + ".";
            mostraMensagem();
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosOrdemServicoItem();
    }
    
    private void PegaDadosOrdemServicoItem(){
        for(int i = 0; i < dadosOrdemServicoItens.size(); i++){
            if(dadosOrdemServicoItens.get(i).get(0) != null){
                bosi.idOrdemServicoItem     = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(0)));
            }
            if(dadosOrdemServicoItens.get(i).get(1) != null){
                bosi.idEmpresa              = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(1)));
            }
            if(dadosOrdemServicoItens.get(i).get(2) != null){
                bosi.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(2)));
            }
            if(dadosOrdemServicoItens.get(i).get(3) != null){
                bosi.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(3)));
            }
            if(dadosOrdemServicoItens.get(i).get(4) != null){
                bosi.codigoOrdemServico     = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(4)));
            }
            if(dadosOrdemServicoItens.get(i).get(5) != null){
                bosi.codigoOrdemServicoItem = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(5)));
            }
            if(dadosOrdemServicoItens.get(i).get(6) != null){
                bosi.codigoUsuario          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(6)));
            }
            if(dadosOrdemServicoItens.get(i).get(7) != null){
                bosi.dataCadastro           =                    String.valueOf(dadosOrdemServicoItens.get(i).get(7));
            }
            if(dadosOrdemServicoItens.get(i).get(8) != null){
                bosi.horaCadastro           =                    String.valueOf(dadosOrdemServicoItens.get(i).get(8));
            }
            if(dadosOrdemServicoItens.get(i).get(9) != null){
                bosi.tipo                   = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(9)));
            }
            if(dadosOrdemServicoItens.get(i).get(10) != null){
                bosi.valorUnitario          = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(10)));
            }
            if(dadosOrdemServicoItens.get(i).get(11) != null){
                bosi.quantidade             = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(11)));
            }
            if(dadosOrdemServicoItens.get(i).get(12) != null){
                bosi.valorTotal             = Double.parseDouble(String.valueOf(dadosOrdemServicoItens.get(i).get(12)));
            }
            if(dadosOrdemServicoItens.get(i).get(13) != null){
                bosi.dataAlterou            =                    String.valueOf(dadosOrdemServicoItens.get(i).get(13));
            }
            if(dadosOrdemServicoItens.get(i).get(14) != null){
                bosi.horaAlterou            =                    String.valueOf(dadosOrdemServicoItens.get(i).get(14));
            }
            if(dadosOrdemServicoItens.get(i).get(15) != null){
                bosi.usuarioAlterou         = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(15)));
            }
            if(dadosOrdemServicoItens.get(i).get(16) != null){
                bosi.idEmpresaAlterou       = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(16)));
            }
            if(dadosOrdemServicoItens.get(i).get(17) != null){
                bosi.codigoGrupoAlterou     = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(17)));
            }
            if(dadosOrdemServicoItens.get(i).get(18) != null){
                bosi.codigoEmpresaAlterou   = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(18)));
            }
            if(dadosOrdemServicoItens.get(i).get(19) != null){
                bosi.codigoServico          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(19)));
            }
            if(dadosOrdemServicoItens.get(i).get(20) != null){
                bosi.codigoProduto          = Integer.parseInt(  String.valueOf(dadosOrdemServicoItens.get(i).get(20)));
            }
        }
        txt_codigoOrdemServicoItem.setText(parametrosNS.fc.FormataCampo(txt_codigoOrdemServicoItem.getText(), 2, 0));
        
        if(operacao.equalsIgnoreCase("A")){
            if(bosi.codigoProduto != 0){
                combo_tipo.setSelectedIndex(1);
                txt_codigoServicoProduto.setText(String.valueOf(bosi.codigoProduto));
            }else{
                combo_tipo.setSelectedIndex(2);
                txt_codigoServicoProduto.setText(String.valueOf(bosi.codigoServico));
            }
        }
        VerificaTipoItemOrdemServico();
        txt_quantidade.setText(String.valueOf(bosi.quantidade));
        
        txt_valorTotal.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bosi.valorTotal), 0));
        
        bu.idEmpresa      = parametrosNS.be.IdEmpresa;
        bu.codigoGrupo    = parametrosNS.bge.CodigoGrupo;
        bu.codigoEmpresa  = parametrosNS.be.CodigoEmpresa;
        bu.codigoUsuario  = bosi.codigoUsuario;
        txt_codigoUsuario.setText(parametrosNS.fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0));
        PegaUsuario();
        label_nomeUsuario.setText(bu.usuario);
        
        txt_dataCadastro.setText(parametrosNS.invdata.inverterData(bosi.dataCadastro, 1));
        txt_horaCadastro.setText(bosi.horaCadastro);
        
        if(bosi.usuarioAlterou != 0){
            bu.usuario          = "NS3";
            bosi.dataAlterou    = parametrosNS.invdata.inverterData(bosi.dataAlterou, 1);
            if(parametrosNS.bu.codigoUsuario != 999){
                bu.idEmpresa        = bosi.idEmpresaAlterou;
                bu.codigoGrupo      = bosi.codigoGrupoAlterou;
                bu.codigoEmpresa    = bosi.codigoEmpresaAlterou;
                bu.codigoUsuario    = bosi.usuarioAlterou;
                PegaUsuario();
            }
            label_alteracao.setText("Última alteração feita em " + bosi.dataAlterou + " às " + bosi.horaAlterou + " por " + bu.usuario + ".");
        }
    }
    
    private void PegaCliente(){
        sql = "select \n"
            + "   idCliente, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoCliente, \n"
            + "   nome, \n"
            + "   cpfCnpj \n"
            + "from \n"
            + "   tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            mensagem = "Cliente " + bc.codigoCliente + " não encontrado!";
            mostraMensagem();
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
        txt_codigoCliente.setText(parametrosNS.fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0));
        label_nomeCliente.setText(bc.nome);
    }
    
    private void PegaUsuario(){
        bu.usuario = "----------";
        if(bu.codigoUsuario == 0)
            return;
        sql = "select usuario from tb_usuarios where idEmpresa = " + bu.idEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuarios.clear();
        dadosUsuarios = parametrosNS.dao.Consulta(sql);
        if(dadosUsuarios.isEmpty()){
            mensagem = "Usuário " + bu.codigoUsuario + " não encontrado!";
            mostraMensagem();
            return;
        }
        PegaDadosUsuario();
    }
    
    private void PegaDadosUsuario(){
        for(int i = 0; i < dadosUsuarios.size(); i++){
            bu.usuario = String.valueOf(dadosUsuarios.get(i).get(0));
        }
    }
    
    private void VerificaTipoItemOrdemServico(){
        if(combo_tipo.getSelectedIndex() == 0){
            mensagem = "Tipo do Item não selecionado!";
            mostraMensagem();
            return;
        }
        if(combo_tipo.getSelectedIndex() == 1){
            txt_codigoServicoProduto.setText(parametrosNS.fc.FormataCampo(txt_codigoServicoProduto.getText(), 6, 0));
            bp.codigoProduto = Integer.parseInt(txt_codigoServicoProduto.getText());
            PegaProdutos();
            return;
        }
        PegaServicos();
    }
    
    private void PegaProdutos(){
        bp.descricaoProduto = "----------";
        if(bp.codigoProduto == 0)
            return;
        sql = "select \n"
            + "   idProdutos, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoProduto, \n"
            + "   descricaoProduto, \n"
            + "   produtoInativo, \n"
            + "   valorDeVenda, \n"
            + "   quantidadeAtual \n"
            + "from \n"
            + "   tb_produtos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoProduto = " + bp.codigoProduto + ";";
        dadosProdutos.clear();
        dadosProdutos = parametrosNS.dao.Consulta(sql);
        if(dadosProdutos.isEmpty()){
            mensagem = "Produto n°" + bp.codigoProduto + " não encontrado!";
            mostraMensagem();
            return;
        }
        PegaDadosProdutos();
    }
    
    private void PegaDadosProdutos(){
        for (int i = 0; i < dadosProdutos.size(); i++) {
            bp  = new BeanProdutos();
            if(dadosProdutos.get(i).get(0) != null){
                bp.idProdutos               = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(0)));
            }
            if(dadosProdutos.get(i).get(1) != null){
                bp.idEmpresa                = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(1)));
            }
            if(dadosProdutos.get(i).get(2) != null){
                bp.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(2)));
            }
            if(dadosProdutos.get(i).get(3) != null){
                bp.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(3)));
            }
            if(dadosProdutos.get(i).get(4) != null){
                bp.codigoProduto            = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(4)));
            }
            if(dadosProdutos.get(i).get(5) != null){
                bp.descricaoProduto         =                    String.valueOf(dadosProdutos.get(i).get(5));
            }
            if(dadosProdutos.get(i).get(6) != null){
                bp.produtoInativo           = Integer.parseInt(  String.valueOf(dadosProdutos.get(i).get(6)));
            }
            if(dadosProdutos.get(i).get(7) != null){
                bp.valorDeVenda             = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(7)));
            }
            if(dadosProdutos.get(i).get(8) != null){
                bp.quantidadeAtual          = Double.parseDouble(String.valueOf(dadosProdutos.get(i).get(8)));
            }
        }
        if(bp.produtoInativo == 1){
            mensagem = "Produto não está mais a venda!";
            mostraMensagem();
            return;
        }
        label_descricao.setText(bp.descricaoProduto);
        txt_valorUnitario.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bp.valorDeVenda), 0));
        txt_quantidade.grabFocus();
    }
    
    private void PegaServicos(){
        txt_codigoServicoProduto.setText(parametrosNS.fc.FormataCampo(txt_codigoServicoProduto.getText(), 6, 0));
        bser.codigoServico = Integer.parseInt(txt_codigoServicoProduto.getText());
        if(bser.codigoServico == 0)
            return;
        sql = "select \n"
            + "   idServico, \n"
            + "   idEmpresa, \n"
            + "   codigoGrupo, \n"
            + "   codigoEmpresa, \n"
            + "   codigoServico, \n"
            + "   descricaoServico, \n"
            + "   valorServico \n"
            + "from \n"
            + "   tb_servicos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoServico = " + bser.codigoServico + ";";
        dadosServicos.clear();
        dadosServicos = parametrosNS.dao.Consulta(sql);
        if(dadosServicos.isEmpty()){
            mensagem = "Serviço código " + bser.codigoServico + " não encontrado!";
            mostraMensagem();
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
            if(dadosServicos.get(i).get(5) != null)
                bser.descricaoServico   =                    String.valueOf(dadosServicos.get(i).get(5));
            if(dadosServicos.get(i).get(6) != null)
                bser.valorServico       = Double.parseDouble(String.valueOf(dadosServicos.get(i).get(6)));
        }
        label_descricao.setText(bser.descricaoServico);
        txt_valorUnitario.setText(parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bser.valorServico), 0));
        txt_quantidade.grabFocus();
    }
    
    private void PegaValores(){
        fatal = "N";
        bosi.idEmpresa                  = parametrosNS.be.IdEmpresa;
        bosi.codigoGrupo                = parametrosNS.bge.CodigoGrupo;
        bosi.codigoEmpresa              = parametrosNS.be.CodigoEmpresa;
        bosi.codigoOrdemServico         = bos.codigoOrdemServico;
        bosi.codigoOrdemServicoItem     = Integer.parseInt(parametrosNS.fc.FormataCampo(txt_codigoOrdemServicoItem.getText(), 2, 0));
        bosi.codigoServicoProduto       = Integer.parseInt(parametrosNS.fc.FormataCampo(txt_codigoServicoProduto.getText(), 6, 0));
        if(bosi.codigoServicoProduto == 0){
            mensagem = "Produto ou serviço inválido!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        bosi.codigoUsuario              = parametrosNS.bu.codigoUsuario;
        bosi.dataCadastro               = parametrosNS.invdata.inverterData(parametrosNS.cdh.CapturarData(), 2);
        bosi.horaCadastro               = parametrosNS.cdh.CapturaHora();
        bosi.tipo                       = combo_tipo.getSelectedIndex();
        if(bosi.tipo == 0){
            mensagem = "Tipo do Item inválido!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        if(bosi.tipo == 1){
            bosi.codigoProduto      = Integer.parseInt(txt_codigoServicoProduto.getText().replace(" ", ""));
            bosi.codigoServico      = 0;
        }else{
            bosi.codigoProduto      = 0;
            bosi.codigoServico      = Integer.parseInt(txt_codigoServicoProduto.getText().replace(" ", ""));
        }
        
        if(txt_valorUnitario.getText().equals("")){
            mensagem = "Valor Unitário inválido!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        bosi.valorUnitario              = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorUnitario.getText(), 1));
        if(txt_quantidade.getText().equals("")){
            mensagem = "Quantidade inválida!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        bosi.quantidade                 = Double.parseDouble(txt_quantidade.getText());
        if(txt_valorTotal.getText().equals("")){
            mensagem = "Valor Total inválido!";
            mostraMensagem();
            fatal = "S";
            return;
        }
        bosi.valorTotal                 = Double.parseDouble(parametrosNS.TransStrDou.TransformaValorStringeDouble(txt_valorTotal.getText(), 1));
        
        bosi.idEmpresaAlterou           = parametrosNS.be.idEmpresa;
        bosi.codigoGrupoAlterou         = parametrosNS.be.codigoGrupo;
        bosi.codigoEmpresaAlterou       = parametrosNS.be.codigoEmpresa;
        bosi.dataAlterou                = parametrosNS.invdata.inverterData(parametrosNS.cdh.CapturarData(), 2);
        bosi.horaAlterou                = parametrosNS.cdh.CapturaHora();
        bosi.usuarioAlterou             = parametrosNS.bu.codigoUsuario;
    }
    
    //AbreConsultas
    private void AbreConsultaProduto(){
        if(ProCon != null)if(ProCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        parametros.clear();
        parametros.add("N");
        parametros.add("Codigo");
        abriuProduto = 1;
        ProCon = new ProdutosConsulta(parametros);
        ProCon.setVisible(true);
    }
    
    private void AbreConsultaServico(){
        if(SerCon != null)if(SerCon.isVisible()){
            mensagem = "Tela já aberta!";
            mostraMensagem();
            return;
        }
        parametros.clear();
        parametros.add("N");
        abriuServico = 1;
        SerCon = new ServicoConsulta(parametros);
        SerCon.setVisible(true);
    }
    //Finaliza AbreConsultas
    
}
