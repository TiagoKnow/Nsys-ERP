package TelasFaturamento;

import BeansNS.BeanCEP;
import BeansNS.BeanEstados;
import BeansNS.BeanPais;
import Beans.BeanTransportadora;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.FormataCampoCpfCnpj;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.PegaProximoRegistro;
import FuncoesInternas.ValidarCpfCnpj;
import FuncoesInternas.ValidarIE;
import Telas.CodigoEnderecamentoPostalConsulta;
import Telas.PaisesConsulta;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/*
 @author Tiago e Paulo
 */
public class TransportadoraCadastro extends javax.swing.JFrame {
    //String's
    String sql                                      = "";
    String sqlstate                                 = "";
    String fatal                                    = "";
    String Mensagem                                 = "";
    String operacao                                 = "";
    String somostra                                 = "";
    String retorno                                  = "";
    
    //int's
    int    abriuCep                                 = 0;
    int    abriuPais                                = 0;
    int    abriuTransCon                            = 0;
    
    //boolean's
    boolean ValidadorCpfCnpj                        = false;
    boolean ValidadorIE                             = false;
    
    //Vetores
    ArrayList            parametros                            = new ArrayList();
    ArrayList            dadosPadroes                          = new ArrayList();
    ArrayList<ArrayList> dadosCEP                              = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosEstados                          = new ArrayList();
    ArrayList<ArrayList> dadosPaises                           = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosTransportadora                   = new ArrayList<ArrayList>();
    
    //Bean's
    BeanCEP                             bcep        = new BeanCEP();
    BeanEstados                         best        = new BeanEstados();
    BeanPais                            bpais       = new BeanPais();
    BeanTransportadora                  btrans      = new BeanTransportadora();
    
    //Especiais
    FormataCampo                        fc          = new FormataCampo();
    FormataCampoCpfCnpj                 FCpfCnpj    = new FormataCampoCpfCnpj();
    ValidarCpfCnpj                      Vcc         = new ValidarCpfCnpj();
    ValidarIE                           VIE         = new ValidarIE();
    PegaProximoRegistro                 PegProReg   = new PegaProximoRegistro();
    
    //Telas
    TransportadoraConsulta              TransCon;
    CodigoEnderecamentoPostalConsulta   ConCodEndPos;
    PaisesConsulta                      ConPaises;
    
    public TransportadoraCadastro(ArrayList DadosPadroes){
        dadosPadroes                    = DadosPadroes;
        
        somostra                        = (String)  dadosPadroes.get(0);
        btrans.codigoTransportadora     = (int)     dadosPadroes.get(1);
        
        initComponents();
    }
    
    private void PegaUF(){
        sql = "select uf from ns_estados;";
        dadosEstados.clear();
        dadosEstados = parametrosNS.dao.Consulta(sql);
        if(dadosEstados.isEmpty()){
            Mensagem = "Unidades Federativas Não encontradas!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosUF();
    }
    
    private void PegaDadosUF(){
        combo_uf.removeAllItems();
        combo_uf.addItem("--");
        for(int i = 0; i < dadosEstados.size(); i++){
            best.uf = String.valueOf(dadosEstados.get(i).get(0));
            combo_uf.addItem(best.uf);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_excluir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_codigoTransportadora = new javax.swing.JFormattedTextField();
        bt_novo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        combo_pessoa = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_cpfcnpj1 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj2 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj3 = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_inscricaoEstadual = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nomeTransportadora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_cep = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_cidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        combo_uf = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txt_bairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_endereco = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_numero = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_codigoPais = new javax.swing.JFormattedTextField();
        bt_pesquisaPais = new javax.swing.JButton();
        label_pais = new javax.swing.JLabel();
        bt_pesquisaCep = new javax.swing.JButton();
        bt_incluir = new javax.swing.JButton();
        bt_alterar = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        bt_pesquisa = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        bt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Delete.png"))); // NOI18N
        bt_excluir.setText("Excluir");
        bt_excluir.setEnabled(false);
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Transportadora");
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
        jLabel1.setText("Código");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_codigoTransportadora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoTransportadora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoTransportadora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoTransportadoraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoTransportadoraFocusLost(evt);
            }
        });

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoTransportadora, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoTransportadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, txt_codigoTransportadora});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pessoa");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        combo_pessoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jurídica", "Física", "Não Informar" }));
        combo_pessoa.setAutoscrolls(true);
        combo_pessoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_pessoaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo_pessoa, 0, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CPF / CNPJ");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_cpfcnpj1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpfcnpj1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpfcnpj1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj1FocusLost(evt);
            }
        });
        txt_cpfcnpj1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cpfcnpj1KeyPressed(evt);
            }
        });

        try {
            txt_cpfcnpj2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpfcnpj2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpfcnpj2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj2FocusLost(evt);
            }
        });
        txt_cpfcnpj2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cpfcnpj2KeyPressed(evt);
            }
        });

        try {
            txt_cpfcnpj3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpfcnpj3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpfcnpj3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfcnpj3FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_cpfcnpj1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cpfcnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_cpfcnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cpfcnpj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpfcnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpfcnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Inscrição Estadual");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txt_inscricaoEstadual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_inscricaoEstadual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_inscricaoEstadualFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_inscricaoEstadual)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_inscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Informações da Transportadora");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nome:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("CEP:");

        try {
            txt_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cepFocusLost(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Cidade:");

        jLabel9.setText("UF:");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Bairro:");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Endereço:");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Número:");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Pais:");

        try {
            txt_codigoPais.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoPais.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoPais.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoPaisFocusLost(evt);
            }
        });

        bt_pesquisaPais.setText("...");
        bt_pesquisaPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaPaisActionPerformed(evt);
            }
        });

        bt_pesquisaCep.setText("...");
        bt_pesquisaCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaCepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nomeTransportadora)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaCep, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_uf, 0, 53, Short.MAX_VALUE))
                            .addComponent(txt_bairro, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_numero, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_endereco, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(txt_codigoPais, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisaPais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(label_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_cidade))))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel12, jLabel6, jLabel7});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel11, jLabel13, jLabel8});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_nomeTransportadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(combo_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaCep, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txt_codigoPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisaPais, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_pais))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_pesquisaCep, bt_pesquisaPais, combo_uf, jLabel10, jLabel11, jLabel12, jLabel13, jLabel6, jLabel7, jLabel8, jLabel9, label_pais, txt_bairro, txt_cep, txt_cidade, txt_codigoPais, txt_endereco, txt_nomeTransportadora, txt_numero});

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

        jMenu1.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        jMenuItem1.setText("Sair");
        jMenu1.add(jMenuItem1);

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel1, jPanel2, jPanel3, jPanel4});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoTransportadoraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoTransportadoraFocusGained
        if(txt_codigoTransportadora.isEditable() == false)
            return;
        if(somostra.equals("S"))
            return;
        operacao = "";
        ReiniciaCampos();
        HabilitaBotoes();
        HabilitaCampos(true);
    }//GEN-LAST:event_txt_codigoTransportadoraFocusGained

    private void txt_codigoTransportadoraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoTransportadoraFocusLost
        if(txt_codigoTransportadora.isEditable() == false)
            return;
        if(txt_codigoTransportadora.getText().replace(" ", "").equals(""))
            return;
        PegaTransportadora();
    }//GEN-LAST:event_txt_codigoTransportadoraFocusLost

    private void combo_pessoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_pessoaItemStateChanged
        if(combo_pessoa.isEnabled() == false)
            return;
        txt_cpfcnpj1    .setText("");
        txt_cpfcnpj1    .setEditable    (true);
        txt_cpfcnpj1    .setFocusable   (true);
        txt_cpfcnpj2    .setText("");
        txt_cpfcnpj2    .setEditable    (true);
        txt_cpfcnpj2    .setFocusable   (true);
        txt_cpfcnpj3    .setText("");
        txt_cpfcnpj3    .setEditable    (true);
        txt_cpfcnpj3    .setFocusable   (true);
        ValidadorCpfCnpj = false;
        if(combo_pessoa.getSelectedIndex() == 1){
            txt_cpfcnpj2.setEditable    (false);
            txt_cpfcnpj2.setFocusable   (false);
            return;
        }
        if(combo_pessoa.getSelectedIndex() == 2){
            txt_cpfcnpj1    .setEditable    (false);
            txt_cpfcnpj1    .setFocusable   (false);
            txt_cpfcnpj2    .setEditable    (false);
            txt_cpfcnpj2    .setFocusable   (false);
            txt_cpfcnpj3    .setEditable    (false);
            txt_cpfcnpj3    .setFocusable   (false);
            ValidadorCpfCnpj = true;
        }
    }//GEN-LAST:event_combo_pessoaItemStateChanged

    private void txt_cepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cepFocusLost
        if(txt_cep.isEditable() == false)
            return;
        PegaCep();
    }//GEN-LAST:event_txt_cepFocusLost

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        ReiniciaCampos();
        HabilitaCampos(true);
        
        btrans.codigoTransportadora = PegProReg.PegaProximoRegistro("tb_transportadoras", "codigoTransportadora", "");
        txt_codigoTransportadora    .setText(fc.FormataCampo(String.valueOf(btrans.codigoTransportadora), 5, 0));
        
        operacao = "I";
        HabilitaBotoes();
        combo_pessoa.grabFocus();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void txt_cpfcnpj1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1FocusGained
        if(txt_cpfcnpj1.isEditable() == false)
            return;
        txt_cpfcnpj1.setText("");
    }//GEN-LAST:event_txt_cpfcnpj1FocusGained

    private void txt_cpfcnpj1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1FocusLost
        if(txt_cpfcnpj1.isEditable() == false)
            return;
        txt_cpfcnpj1.setText(fc.FormataCampo(txt_cpfcnpj1.getText(), 11, 2));
        if(txt_cpfcnpj2.isEditable() == true){
            txt_cpfcnpj2.setText("");
        }
    }//GEN-LAST:event_txt_cpfcnpj1FocusLost

    private void txt_cpfcnpj1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1KeyPressed
        if(txt_cpfcnpj1.isEditable() == false)
            return;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(txt_cpfcnpj2.isFocusable()){txt_cpfcnpj2.grabFocus();}else{txt_cpfcnpj3.grabFocus();}
        }
    }//GEN-LAST:event_txt_cpfcnpj1KeyPressed

    private void txt_cpfcnpj2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj2FocusGained
        if(txt_cpfcnpj2.isEditable() == false)
            return;
        txt_cpfcnpj2.setText("");
    }//GEN-LAST:event_txt_cpfcnpj2FocusGained

    private void txt_cpfcnpj2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj2FocusLost
        if(txt_cpfcnpj2.isEditable()== false)
            return;
        txt_cpfcnpj2.setText(fc.FormataCampo(txt_cpfcnpj2.getText(), 4, 0));
    }//GEN-LAST:event_txt_cpfcnpj2FocusLost

    private void txt_cpfcnpj2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfcnpj2KeyPressed
        if(txt_cpfcnpj2.isEditable() == false)
            return;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_cpfcnpj3.grabFocus();
        }
    }//GEN-LAST:event_txt_cpfcnpj2KeyPressed

    private void txt_cpfcnpj3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj3FocusGained
        if(txt_cpfcnpj3.isEditable() == false)
            return;
        txt_cpfcnpj3.setText("");
    }//GEN-LAST:event_txt_cpfcnpj3FocusGained

    private void txt_cpfcnpj3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj3FocusLost
        if(txt_cpfcnpj3.isEditable() == false)
            return;
        txt_cpfcnpj3.setText(fc.FormataCampo(txt_cpfcnpj3.getText(), 2, 0));
        ValidaCPFCNPJ();
    }//GEN-LAST:event_txt_cpfcnpj3FocusLost

    private void txt_inscricaoEstadualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_inscricaoEstadualFocusLost
        if(txt_inscricaoEstadual.isEditable() == false)
            return;
        btrans.InscricaoEstadual    = txt_inscricaoEstadual.getText().replace(" ", "");
        ValidadorIE = VIE.ValidadorDeIE(btrans.InscricaoEstadual);
        HabilitaBotoes();
        if(ValidadorIE == false){
            bt_incluir  .setEnabled(false);
            bt_alterar  .setEnabled(false);
            bt_excluir  .setEnabled(false);
            if(!btrans.InscricaoEstadual.equals("")){
                Mensagem = "Inscrição Estadual Inválida!";
                new MostraMensagem(Mensagem);
            }
        }
    }//GEN-LAST:event_txt_inscricaoEstadualFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        PegaUF();
        if(btrans.codigoTransportadora != 0){
            txt_codigoTransportadora.setText(String.valueOf(btrans.codigoTransportadora));
            PegaTransportadora();
        }
        if(somostra.equals("S")){
            txt_codigoTransportadora        .setEditable(false);
            bt_novo                         .setEnabled (false);
            combo_pessoa                    .setEnabled (false);
            txt_cpfcnpj1                    .setEditable(false);
            txt_cpfcnpj2                    .setEditable(false);
            txt_cpfcnpj3                    .setEditable(false);
            txt_inscricaoEstadual           .setEditable(false);
            txt_cep                         .setEditable(false);
            bt_pesquisaCep                  .setEnabled (false);
            txt_codigoPais                  .setEditable(false);
            bt_pesquisaPais                 .setEnabled (false);
            bt_pesquisa                     .setVisible (false);
            bt_incluir                      .setVisible (false);
            bt_alterar                      .setVisible (false);
            bt_excluir                      .setVisible (false);
        }
        if(somostra.equals("SN"))
            bt_pesquisa.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void txt_codigoPaisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoPaisFocusLost
        if(txt_codigoPais.isEditable() == false)
            return;
        if(txt_codigoPais.getText().replace(" ", "").equals(""))
            return;
        PegaPais();
    }//GEN-LAST:event_txt_codigoPaisFocusLost

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "insert into tb_transportadoras (idEmpresa, codigoGrupo, codigoEmpresa, codigoTransportadora, fisicaJuridica, cpfCnpj, InscricaoEstadual, NomeTransportadora, Cep, Uf, Cidade, Bairro, Endereco, Numero, codigoPais) " +
              "values (" + btrans.idEmpresa + ", " + btrans.codigoGrupo + ", " + btrans.codigoEmpresa + ", " + btrans.codigoTransportadora + ", " + btrans.fisicaJuridica + ", '" + btrans.cpfCnpj + "', '" + btrans.InscricaoEstadual + "', '" + btrans.NomeTransportadora + "', " + btrans.Cep + ", '" + btrans.Uf + "', '" + btrans.Cidade + "', '" + btrans.Bairro + "', '" + btrans.Endereco + "', '" + btrans.Numero + "', " + btrans.codigoPais + ");";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoTransportadora.grabFocus();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
        PegaValores();
        if(fatal.equals("S"))return;
        
        sql = "update tb_transportadoras set fisicaJuridica = "             + btrans.fisicaJuridica         + ", "  +
                                            "cpfCnpj = '"                   + btrans.cpfCnpj                + "', " +
                                            "InscricaoEstadual = '"         + btrans.InscricaoEstadual      + "', " +
                                            "NomeTransportadora = '"        + btrans.NomeTransportadora     + "', " +
                                            "Cep = '"                       + btrans.Cep                    + "', " +
                                            "Uf = '"                        + btrans.Uf                     + "', " +
                                            "Cidade = '"                    + btrans.Cidade                 + "', " +
                                            "Bairro = '"                    + btrans.Bairro                 + "', " +
                                            "Endereco = '"                  + btrans.Endereco               + "', " +
                                            "Numero = '"                    + btrans.Numero                 + "', " +
                                            "codigoPais = "                 + btrans.codigoPais             + " "   +
                                            "where idTransportadora = " + btrans.idTransportadora       + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoTransportadora.grabFocus();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        btrans.codigoTransportadora  = Integer.parseInt(txt_codigoTransportadora.getText());
        if(JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o registro n°" + btrans.codigoTransportadora + "?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
            return;
        
        sql = "delete from tb_transportadoras where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoTransportadora = " + btrans.codigoTransportadora + ";";
        sqlstate = parametrosNS.dao.ExcluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        txt_codigoTransportadora.grabFocus();
    }//GEN-LAST:event_bt_excluirActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuCep == 0){
            AbrePais();
            return;
        }
        abriuCep = 0;
        retorno = ConCodEndPos.getRetorno();
        if(retorno.equals(""))
            return;
        txt_cep.setText(retorno);
        PegaCep();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbrePais(){
        if(abriuPais == 0){
            AbreTransportadora();
            return;
        }
        abriuPais = 0;
        retorno = ConPaises.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoPais.setText(fc.FormataCampo(retorno, 4, 0));
        PegaPais();
    }
    
    private void AbreTransportadora(){
        if(abriuTransCon == 0)
            return;
        abriuTransCon = 0;
        retorno = TransCon.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoTransportadora.setText(retorno);
        PegaTransportadora();
    }
    
    private void bt_pesquisaCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaCepActionPerformed
        if(ConCodEndPos != null)if(ConCodEndPos.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        
        }
        abriuCep = 1;
        ConCodEndPos = new CodigoEnderecamentoPostalConsulta();
        ConCodEndPos.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaCepActionPerformed

    private void bt_pesquisaPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaPaisActionPerformed
        if(ConPaises != null)if(ConPaises.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuPais = 1;
        ConPaises = new PaisesConsulta();
        ConPaises.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaPaisActionPerformed

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        parametros.clear();
        parametros.add("S");
        if(TransCon != null)if(TransCon.isVisible()){
            Mensagem = "Tela já aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuTransCon = 1;
        TransCon = new TransportadoraConsulta(parametros);
        TransCon.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(TransCon     != null)TransCon    .dispose();
        if(ConCodEndPos != null)ConCodEndPos.dispose();
        if(ConPaises    != null)ConPaises   .dispose();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_pesquisaCep;
    private javax.swing.JButton bt_pesquisaPais;
    private javax.swing.JButton bt_sair;
    private javax.swing.JComboBox<String> combo_pessoa;
    private javax.swing.JComboBox<String> combo_uf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel label_pais;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JFormattedTextField txt_cep;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JFormattedTextField txt_codigoPais;
    private javax.swing.JFormattedTextField txt_codigoTransportadora;
    private javax.swing.JFormattedTextField txt_cpfcnpj1;
    private javax.swing.JFormattedTextField txt_cpfcnpj2;
    private javax.swing.JFormattedTextField txt_cpfcnpj3;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JFormattedTextField txt_inscricaoEstadual;
    private javax.swing.JTextField txt_nomeTransportadora;
    private javax.swing.JTextField txt_numero;
    // End of variables declaration//GEN-END:variables
    
    private void ReiniciaCampos(){
        txt_codigoTransportadora    .setText("");
        combo_pessoa                .setSelectedIndex(0);
        ValidadorCpfCnpj            = false;
        txt_cpfcnpj1                .setText("");
        txt_cpfcnpj2                .setText("");
        txt_cpfcnpj3                .setText("");
        txt_inscricaoEstadual       .setText("");
        txt_nomeTransportadora      .setText("");
        txt_cep                     .setText("");
        combo_uf                    .setSelectedIndex(0);
        txt_cidade                  .setText("");
        txt_bairro                  .setText("");
        txt_endereco                .setText("");
        txt_numero                  .setText("");
        txt_codigoPais              .setText("");
        label_pais                  .setText("");
    }
    
    private void HabilitaCampos(boolean Habilita){
        combo_pessoa                .setEnabled     (Habilita);
        combo_pessoa                .setFocusable   (Habilita);
        txt_cpfcnpj1                .setEditable    (Habilita);
        txt_cpfcnpj1                .setFocusable   (Habilita);
        txt_cpfcnpj2                .setEditable    (Habilita);
        txt_cpfcnpj2                .setFocusable   (Habilita);
        txt_cpfcnpj3                .setEditable    (Habilita);
        txt_cpfcnpj3                .setFocusable   (Habilita);
        txt_cpfcnpj3                .setEditable    (Habilita);
        txt_cpfcnpj3                .setFocusable   (Habilita);
        txt_inscricaoEstadual       .setEditable    (Habilita);
        txt_inscricaoEstadual       .setFocusable   (Habilita);
        txt_nomeTransportadora      .setEditable    (Habilita);
        txt_nomeTransportadora      .setFocusable   (Habilita);
        txt_cep                     .setEditable    (Habilita);
        txt_cep                     .setFocusable   (Habilita);
        bt_pesquisaCep              .setEnabled     (Habilita);
        bt_pesquisaCep              .setFocusable   (Habilita);
        combo_uf                    .setEnabled     (Habilita);
        combo_uf                    .setFocusable   (Habilita);
        txt_cidade                  .setEditable    (Habilita);
        txt_cidade                  .setFocusable   (Habilita);
        txt_bairro                  .setEditable    (Habilita);
        txt_bairro                  .setFocusable   (Habilita);
        txt_endereco                .setEditable    (Habilita);
        txt_endereco                .setFocusable   (Habilita);
        txt_numero                  .setEditable    (Habilita);
        txt_numero                  .setFocusable   (Habilita);
        txt_codigoPais              .setEditable    (Habilita);
        txt_codigoPais              .setFocusable   (Habilita);
        bt_pesquisaPais             .setEnabled     (Habilita);
        bt_pesquisaPais             .setFocusable   (Habilita);
    }
    
    private void HabilitaBotoes(){
        if(operacao.equals("I")){
            bt_incluir      .setEnabled(true);
            bt_alterar      .setEnabled(false);
            bt_excluir      .setEnabled(false);
            return;
        }
        if(operacao.equals("A")){
            bt_incluir      .setEnabled(false);
            bt_alterar      .setEnabled(true);
            bt_excluir      .setEnabled(true);
            return;
        }
        bt_incluir          .setEnabled(false);
        bt_alterar          .setEnabled(false);
        bt_excluir          .setEnabled(false);
    }
    private void ValidaCPFCNPJ(){
        btrans.cpfCnpj1 = txt_cpfcnpj1.getText().replace(" ", "");
        btrans.cpfCnpj2 = txt_cpfcnpj2.getText().replace(" ", "");
        btrans.cpfCnpj3 = txt_cpfcnpj3.getText().replace(" ", "");
        
        btrans.cpfCnpj = btrans.cpfCnpj1 + btrans.cpfCnpj2 + btrans.cpfCnpj3;
        ValidadorCpfCnpj = Vcc.VALIDARCPFCNPJ(btrans.cpfCnpj);
        if(ValidadorCpfCnpj != false){
            HabilitaBotoes();
            return;
        }
        if(combo_pessoa.getSelectedIndex() == 0){
            Mensagem = "CNPJ Inválido!";
            new MostraMensagem(Mensagem);
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(false);
            bt_excluir.setEnabled(false);
            return;
        }else{
            Mensagem = "CPF Inválido!";
            new MostraMensagem(Mensagem);
            bt_incluir.setEnabled(false);
            bt_alterar.setEnabled(false);
            bt_excluir.setEnabled(false);
            return;
        }
    }
    
    private void PegaTransportadora(){
        txt_codigoTransportadora    .setText(fc.FormataCampo(txt_codigoTransportadora.getText(), 5, 0));
        btrans.codigoTransportadora = Integer.parseInt(txt_codigoTransportadora.getText());
        if(btrans.codigoTransportadora == 0)
            return;
        sql = "select * from tb_transportadoras where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoTransportadora = " + btrans.codigoTransportadora + ";";
        dadosTransportadora.clear();
        dadosTransportadora = parametrosNS.dao.Consulta(sql);
        if(dadosTransportadora.isEmpty()){
            Mensagem = "Transportadora n°" + btrans.codigoTransportadora + " não encontrada!";
            new MostraMensagem(Mensagem);
            return;
        }
        operacao = "A";
        HabilitaBotoes();
        HabilitaCampos(true);
        PegaDadosTransportadora();
    }
    
    private void PegaDadosTransportadora(){
        for(int i = 0; i < dadosTransportadora.size(); i++){
            btrans = new BeanTransportadora();
            if(dadosTransportadora.get(i).get(0) != null)
                btrans.idTransportadora     = Integer.parseInt(  String.valueOf(dadosTransportadora.get(i).get(0)));
            if(dadosTransportadora.get(i).get(1) != null)
                btrans.idEmpresa            = Integer.parseInt(  String.valueOf(dadosTransportadora.get(i).get(1)));
            if(dadosTransportadora.get(i).get(2) != null)
                btrans.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosTransportadora.get(i).get(2)));
            if(dadosTransportadora.get(i).get(3) != null)
                btrans.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosTransportadora.get(i).get(3)));
            if(dadosTransportadora.get(i).get(4) != null)
                btrans.codigoTransportadora = Integer.parseInt(  String.valueOf(dadosTransportadora.get(i).get(4)));
            if(dadosTransportadora.get(i).get(5) != null)
                btrans.fisicaJuridica       = Integer.parseInt(  String.valueOf(dadosTransportadora.get(i).get(5)));
                btrans.cpfCnpj              =                    String.valueOf(dadosTransportadora.get(i).get(6));
                btrans.InscricaoEstadual    =                    String.valueOf(dadosTransportadora.get(i).get(7));
                btrans.NomeTransportadora   =                    String.valueOf(dadosTransportadora.get(i).get(8));
                btrans.Cep                  =                    String.valueOf(dadosTransportadora.get(i).get(9));
                btrans.Uf                   =                    String.valueOf(dadosTransportadora.get(i).get(10));
                btrans.Cidade               =                    String.valueOf(dadosTransportadora.get(i).get(11));
                btrans.Bairro               =                    String.valueOf(dadosTransportadora.get(i).get(12));
                btrans.Endereco             =                    String.valueOf(dadosTransportadora.get(i).get(13));
                btrans.Numero               =                    String.valueOf(dadosTransportadora.get(i).get(14));
            if(dadosTransportadora.get(i).get(15) != null)
                btrans.codigoPais           = Integer.parseInt(  String.valueOf(dadosTransportadora.get(i).get(15)));
        }
        combo_pessoa            .setSelectedIndex(btrans.fisicaJuridica);
        btrans.cpfCnpj          = FCpfCnpj.FormataCampoCpfCnpj(btrans.cpfCnpj);
        txt_cpfcnpj1            .setText(btrans.cpfCnpj.substring(0 , 9));
        txt_cpfcnpj2            .setText(btrans.cpfCnpj.substring(9 ,13));
        txt_cpfcnpj3            .setText(btrans.cpfCnpj.substring(13,15));
        txt_inscricaoEstadual   .setText(btrans.InscricaoEstadual);
        txt_nomeTransportadora  .setText(btrans.NomeTransportadora);
        txt_cep                 .setText(btrans.Cep);
        
        txt_codigoPais  .setText(String.valueOf(btrans.codigoPais));
        PegaPais();
            
        if(btrans.Endereco.equals("")){
            PegaCep();
            btrans.Endereco     = bcep.endereco;
            btrans.Cidade       = bcep.cidade;
            btrans.Bairro       = bcep.bairro;
            btrans.Uf           = bcep.uf;
        }
        combo_uf        .setSelectedItem(btrans.Uf);
        txt_cidade      .setText(btrans.Cidade);
        txt_bairro      .setText(btrans.Bairro);
        txt_endereco    .setText(btrans.Endereco);
        txt_numero              .setText(btrans.Numero);
    }
    
    private void PegaCep(){
        btrans.Cep      = txt_cep.getText().replace(" ", "");
        btrans.Cep      = btrans.Cep.replace("-", "");
        if(btrans.Cep.equals(""))
            return;
        sql = "select * from ns_cep where cep = '" + btrans.Cep + "';";
        dadosCEP.clear();
        dadosCEP = parametrosNS.dao.Consulta(sql);
        if(dadosCEP.isEmpty()){
            Mensagem = "Cep " + btrans.Cep + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosCep();
    }
    
    private void PegaDadosCep(){
        for(int i = 0; i < dadosCEP.size(); i++){
            bcep.cep        = String.valueOf(dadosCEP.get(i).get(0));
            bcep.endereco   = String.valueOf(dadosCEP.get(i).get(1));
            bcep.cidade     = String.valueOf(dadosCEP.get(i).get(2));
            bcep.bairro     = String.valueOf(dadosCEP.get(i).get(3));
            bcep.uf         = String.valueOf(dadosCEP.get(i).get(4));
        }
        combo_uf        .setSelectedItem(bcep.uf);
        txt_cidade      .setText(bcep.cidade);
        txt_bairro      .setText(bcep.bairro);
        txt_endereco    .setText(bcep.endereco);
        txt_codigoPais  .setText("1058");
        PegaPais();
    }
    
    private void PegaPais(){
        txt_codigoPais.setText(fc.FormataCampo(txt_codigoPais.getText(), 4, 0));
        bpais.codigoPais    = Integer.parseInt(txt_codigoPais.getText());
        if(bpais.codigoPais == 0)
            return;
        sql = "select * from ns_paises where codigoPais = " + bpais.codigoPais + ";";
        dadosPaises.clear();
        dadosPaises = parametrosNS.dao.Consulta(sql);
        if(dadosPaises.isEmpty()){
            label_pais.setText("Não existe!");
            return;
        }
        PegaDadosPais();
    }
    
    private void PegaDadosPais(){
        for(int i = 0; i < dadosPaises.size(); i++){
            bpais.codigoPais = Integer.parseInt(  String.valueOf(dadosPaises.get(i).get(0)));
            bpais.nomePais   =                    String.valueOf(dadosPaises.get(i).get(1));
        }
        label_pais.setText(bpais.nomePais);
    }
    
    private void PegaValores(){
        fatal = "N";
        btrans.idEmpresa                = parametrosNS.be.IdEmpresa;
        btrans.codigoGrupo              = parametrosNS.bge.CodigoGrupo;
        btrans.codigoEmpresa            = parametrosNS.be.CodigoEmpresa;
        btrans.codigoTransportadora     = Integer.parseInt(txt_codigoTransportadora.getText());
        btrans.fisicaJuridica           = combo_pessoa.getSelectedIndex();
        if(ValidadorCpfCnpj == false){
            switch(btrans.fisicaJuridica){
                case 0: Mensagem = "CNPJ Inválido!"; break;
                case 1: Mensagem = "CPF  Inválido!"; break;
            }
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        btrans.cpfCnpj1                 = txt_cpfcnpj1.getText().replace(" ", "");
        btrans.cpfCnpj2                 = txt_cpfcnpj2.getText().replace(" ", "");
        btrans.cpfCnpj3                 = txt_cpfcnpj3.getText().replace(" ", "");
        btrans.cpfCnpj                  = btrans.cpfCnpj1 + btrans.cpfCnpj2 + btrans.cpfCnpj3;
        if(ValidadorIE == false){
            Mensagem = "Inscrição Estadual Inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        btrans.InscricaoEstadual        = txt_inscricaoEstadual.getText().replace(" ", "");
        if(!btrans.InscricaoEstadual.equalsIgnoreCase("ISENTO")){
            btrans.InscricaoEstadual        = btrans.InscricaoEstadual.replace(".", "");
            btrans.InscricaoEstadual1       = btrans.InscricaoEstadual.substring(0, 3);
            btrans.InscricaoEstadual2       = btrans.InscricaoEstadual.substring(3, 6);
            btrans.InscricaoEstadual3       = btrans.InscricaoEstadual.substring(6, 9);
            btrans.InscricaoEstadual4       = btrans.InscricaoEstadual.substring(9,12);
            btrans.RecarregaInscricaoEstadual();
        }
        btrans.NomeTransportadora       = txt_nomeTransportadora.getText();
        btrans.Cep                      = txt_cep.getText().replace(" ", "");
        btrans.Cep                      = btrans.Cep.replace("-", "");
        if(!btrans.Cep.equals("")){
            btrans.Cep      = "'" + txt_cep.getText() + "'";
        }else{
            btrans.Cep      = null;
        }
        btrans.Uf                       = String.valueOf(combo_uf.getSelectedItem());
        btrans.Uf                       = btrans.Uf.replace("-", "");
        if(btrans.Uf.equals("")){
            Mensagem = "Unidade Federativa(UF) Inválida!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        btrans.Cidade                   = txt_cidade.getText();
        btrans.Bairro                   = txt_bairro.getText();
        btrans.Endereco                 = txt_endereco.getText();
        btrans.Numero                   = txt_numero.getText();
        btrans.codigoPais               = Integer.parseInt(fc.FormataCampo(txt_codigoPais.getText().replace(" ", ""), 4, 0));
    }
    
}
