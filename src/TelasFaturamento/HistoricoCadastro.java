package TelasFaturamento;

import Beans.BeanClientes;
import Beans.BeanUsuarios;
import Beans.BeanClientesHistorico;
import Beans.BeanClientesHistoricoLista;
import FuncoesInternas.InverterData;
import Dao.DaoMySQL;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import java.sql.Connection;
import java.util.*;
import javax.swing.JOptionPane;
/**
 * @author Tiago e Paulo
 */
public class HistoricoCadastro extends javax.swing.JFrame {
    //String's
    String sql                              = "";
    String sqlstate                         = "";
    String mensagem                         = "";
    
    //ArrayList's
    ArrayList            parametros                    = new ArrayList();
    ArrayList            dadosPadroes                  = new ArrayList();
    ArrayList<ArrayList> dadosCliente                  = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosPredefenidas             = new ArrayList<ArrayList>();
    
    //Bean's
    BeanUsuarios                    bu      = new BeanUsuarios();
    BeanClientes                    bc      = new BeanClientes();
    BeanClientesHistorico           bhis    = new BeanClientesHistorico();
    BeanClientesHistoricoLista      bchl    = new BeanClientesHistoricoLista();
    
    //Especiais
    FormataCampoCpfCnpj             FCampoCpfCnpj   = new FormataCampoCpfCnpj();
    CapturarDataHora                cdh             = new CapturarDataHora();
    FormataCampo                    fc              = new FormataCampo();
    InverterData                    invdata         = new InverterData();
    PegaProximoRegistro             PegProReg       = new PegaProximoRegistro();
    
    //Telas
    HistoricoConsulta               HisCon;
    
    public HistoricoCadastro(ArrayList DadosPadroes){
        dadosPadroes = DadosPadroes;
        
        bc.codigoCliente            = (int)     dadosPadroes.get(0);
        
        initComponents();
    }
    
    private void InicializaCampos(){
        txt_dataCadastro.setText(cdh.CapturarData());
        txt_horaCadastro.setText(cdh.CapturaHora());
    }
    
    private void PegaCliente(){
        sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, cpfCnpj, nome from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty()){
            mensagem = "Cliente " + bc.codigoCliente + " não encontrado!";
            mostraMensagem();
//            ReiniciaCampos(false);
            return;
        }
        PreencherCliente();
    }
    
    private void PreencherCliente(){
        for(int i = 0; i < dadosCliente.size(); i++){
            bc = new BeanClientes();
            bc.idCliente            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(0)));
            bc.idEmpresa            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(1)));
            bc.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(2)));
            bc.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(3)));
            bc.codigoCliente        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(4)));
            bc.cpfCnpj              =                    String.valueOf(dadosCliente.get(i).get(5));
            bc.nome                 =                    String.valueOf(dadosCliente.get(i).get(6));
        }
        txt_codigoCliente.setText(fc.FormataCampo(String.valueOf(bc.codigoCliente), 5, 0));
        label_nomeCliente.setText(bc.nome);
        bc.cpfCnpj  = FCampoCpfCnpj.FormataCampoCpfCnpj(bc.cpfCnpj);
        txt_cpfcnpj1.setText(bc.cpfCnpj.substring(0 , 9));
        txt_cpfcnpj2.setText(bc.cpfCnpj.substring(9 ,13));
        txt_cpfcnpj3.setText(bc.cpfCnpj.substring(13,15));
        PegaPredefenidas();
    }
    
    private void PegaPredefenidas(){
        sql = "select * from tb_clientes_historico_listas where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosPredefenidas.clear();
        dadosPredefenidas = parametrosNS.dao.Consulta(sql);
        if(dadosPredefenidas.isEmpty()){
            mensagem = "Não foram encontradas listas predefenidas cadastradas!";
            mostraMensagem();
            dispose();
            return;
        }
        PreencherPredefenidas();
    }
    
    private void PreencherPredefenidas(){
        combo_lista.removeAllItems();
        combo_lista.addItem("");
        for(int i = 0; i < dadosPredefenidas.size(); i++){
            bchl = new BeanClientesHistoricoLista();
            bchl.idClienteHistorico         = Integer.parseInt(  String.valueOf(dadosPredefenidas.get(i).get(0)));
            bchl.idEmpresa                  = Integer.parseInt(  String.valueOf(dadosPredefenidas.get(i).get(1)));
            bchl.codigoGrupo                = Integer.parseInt(  String.valueOf(dadosPredefenidas.get(i).get(2)));
            bchl.codigoEmpresa              = Integer.parseInt(  String.valueOf(dadosPredefenidas.get(i).get(3)));
            bchl.codigoPredefenido          = Integer.parseInt(  String.valueOf(dadosPredefenidas.get(i).get(4)));
            bchl.descricaoPredefenida       =                    String.valueOf(dadosPredefenidas.get(i).get(5));
            bchl.dataCadastro               =                    String.valueOf(dadosPredefenidas.get(i).get(6));
            
            combo_lista.addItem(bchl.descricaoPredefenida);
        }
        txt_descricaoHistorico.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        combo_lista = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descricaoHistorico = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        bt_sair = new javax.swing.JButton();
        bt_incluir = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        txt_cpfcnpj1 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj2 = new javax.swing.JFormattedTextField();
        txt_cpfcnpj3 = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        label_nomeCliente = new javax.swing.JLabel();
        txt_codigoCliente = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_dataCadastro = new javax.swing.JFormattedTextField();
        txt_horaCadastro = new javax.swing.JFormattedTextField();
        bt_pesquisa = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(":: Histórico do Cliente");
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

        jLabel5.setText("Observações Predefinidas: ");

        combo_lista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        combo_lista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_listaItemStateChanged(evt);
            }
        });
        combo_lista.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                combo_listaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_listaFocusLost(evt);
            }
        });

        txt_descricaoHistorico.setColumns(20);
        txt_descricaoHistorico.setRows(5);
        txt_descricaoHistorico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoHistoricoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txt_descricaoHistorico);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Observações");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(combo_lista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_lista, jLabel5});

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        bt_incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_incluir.setText("Incluir");
        bt_incluir.setEnabled(false);
        bt_incluir.setFocusable(false);
        bt_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_incluirActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("CNPJ");
        jLabel33.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_cpfcnpj1.setEditable(false);
        try{
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
        try{
            txt_cpfcnpj2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpfcnpj2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cpfcnpj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpfcnpj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpfcnpj3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cliente");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_nomeCliente.setFocusable(false);
        label_nomeCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_nomeClienteMouseEntered(evt);
            }
        });

        try{
            txt_codigoCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoCliente.setEditable(false);
        txt_codigoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_nomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_codigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Data");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_dataCadastro.setEditable(false);
        try {
            txt_dataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_dataCadastro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dataCadastro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dataCadastroCadastroFocusLost(evt);
            }
        });
        txt_dataCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dataCadastroCadastroActionPerformed(evt);
            }
        });

        txt_horaCadastro.setEditable(false);
        try {
            txt_horaCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_horaCadastro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_horaCadastro.setText("  :  ");
        txt_horaCadastro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_horaCadastroCadastroFocusLost(evt);
            }
        });
        txt_horaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_horaCadastroCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_dataCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_horaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_horaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bt_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisa.setText("Pesquisa");
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaActionPerformed(evt);
            }
        });

        jMenu1.setText(":: Arquivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText(":: Relatórios");

        jMenuItem1.setText(":: Relatório de Contatos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(bt_incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_sair))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_incluir, bt_sair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_incluir, bt_pesquisa, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dataCadastroCadastroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dataCadastroCadastroFocusLost
        
    }//GEN-LAST:event_txt_dataCadastroCadastroFocusLost

    private void txt_dataCadastroCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dataCadastroCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dataCadastroCadastroActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void combo_listaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_listaItemStateChanged
        txt_descricaoHistorico.setText("");
        if(combo_lista.getSelectedIndex() == 0){
            bt_incluir              .setEnabled     (false);
            bt_incluir              .setFocusable   (false);
            txt_descricaoHistorico  .setEditable    (false);
            txt_descricaoHistorico  .setFocusable   (false);
            return;
        }
        bt_incluir              .setEnabled     (true);
        bt_incluir              .setFocusable   (true);
        txt_descricaoHistorico  .setEditable    (true);
        txt_descricaoHistorico  .setFocusable   (true);
        txt_descricaoHistorico.setText(String.valueOf(combo_lista.getSelectedItem()) + ": ");
        txt_descricaoHistorico.grabFocus();
    }//GEN-LAST:event_combo_listaItemStateChanged

    private void txt_cpfcnpj1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1FocusGained
        txt_cpfcnpj1.setText("");
    }//GEN-LAST:event_txt_cpfcnpj1FocusGained

    private void txt_cpfcnpj1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1FocusLost
        
    }//GEN-LAST:event_txt_cpfcnpj1FocusLost

    private void txt_cpfcnpj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfcnpj1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfcnpj1ActionPerformed

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

    private void txt_codigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoClienteActionPerformed

    private void bt_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_incluirActionPerformed
        PegaValores();
        sql = "insert into tb_clientes_historico (idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, codigoHistorico, codigoUsuario, descricaoHistorico, dataCadastro, horaCadastro) "
            + "values (" + bhis.idEmpresa + ", " + bhis.codigoGrupo + ", " + bhis.codigoEmpresa + ", " + bhis.codigoCliente + ", " + bhis.codigoHistorico + ", " + bhis.codigoUsuario + ", '" + bhis.descricaoHistorico + "', '" + bhis.dataCadastro + "', '" + bhis.horaCadastro + "');";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            mensagem = "";
            mostraMensagem();
            return;
        }
        combo_lista.setSelectedIndex(0);
        AbrePesquisaHistorico();
    }//GEN-LAST:event_bt_incluirActionPerformed

    private void combo_listaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_listaFocusGained
        txt_descricaoHistorico  .setText        ("");
        bt_incluir              .setEnabled     (false);
        bt_incluir              .setFocusable   (false);
    }//GEN-LAST:event_combo_listaFocusGained

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void combo_listaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_listaFocusLost
        
    }//GEN-LAST:event_combo_listaFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        InicializaCampos();
        PegaCliente();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    private void txt_horaCadastroCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_horaCadastroCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_horaCadastroCadastroActionPerformed

    private void txt_horaCadastroCadastroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_horaCadastroCadastroFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_horaCadastroCadastroFocusLost

    private void txt_descricaoHistoricoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoHistoricoKeyReleased
        if(txt_descricaoHistorico.getText().replace(" ", "").equals("")){
            bt_incluir  .setEnabled     (false);
            bt_incluir  .setFocusable   (false);
            return;
        }
        bt_incluir  .setEnabled     (true);
        bt_incluir  .setFocusable   (true);
    }//GEN-LAST:event_txt_descricaoHistoricoKeyReleased

    private void label_nomeClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_nomeClienteMouseEntered
        if(!label_nomeCliente.getText().equals(""))label_nomeCliente.setToolTipText(label_nomeCliente.getText());
    }//GEN-LAST:event_label_nomeClienteMouseEntered

    private void bt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaActionPerformed
        AbrePesquisaHistorico();
    }//GEN-LAST:event_bt_pesquisaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(HisCon   != null)HisCon.dispose();
    }//GEN-LAST:event_formWindowClosed
    
    private void AbrePesquisaHistorico(){
        parametros.clear();
        parametros.add(Integer.parseInt(txt_codigoCliente.getText().replace(" ", "")));
        if(HisCon   != null)if(HisCon.isVisible()){
            mensagem = "Tela já Aberta!";
            mostraMensagem();
            return;
        }
        HisCon = new HistoricoConsulta(parametros);
        HisCon.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_incluir;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JButton bt_sair;
    private javax.swing.JComboBox<String> combo_lista;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_nomeCliente;
    private javax.swing.JFormattedTextField txt_codigoCliente;
    private javax.swing.JFormattedTextField txt_cpfcnpj1;
    private javax.swing.JFormattedTextField txt_cpfcnpj2;
    private javax.swing.JFormattedTextField txt_cpfcnpj3;
    private javax.swing.JFormattedTextField txt_dataCadastro;
    private javax.swing.JTextArea txt_descricaoHistorico;
    private javax.swing.JFormattedTextField txt_horaCadastro;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void PegaValores(){
        bhis.idEmpresa              = parametrosNS.be.IdEmpresa;
        bhis.codigoGrupo            = parametrosNS.bge.CodigoGrupo;
        bhis.codigoEmpresa          = parametrosNS.be.CodigoEmpresa;
        bhis.codigoCliente          = bc.codigoCliente;
        bhis.codigoHistorico        = PegProReg.PegaProximoRegistro("tb_clientes_historico", "codigoHistorico", "");
        bhis.codigoUsuario          = parametrosNS.bu.codigoUsuario;
        bhis.descricaoHistorico     = txt_descricaoHistorico.getText();
        bhis.dataCadastro           = invdata.inverterData(txt_dataCadastro.getText(), 2);
        bhis.horaCadastro           = txt_horaCadastro.getText();
    }
    
}
