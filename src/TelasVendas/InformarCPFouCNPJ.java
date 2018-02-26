package TelasVendas;

import Beans.BeanCaixaAbertura;
import Beans.BeanClientes;
import TelasFaturamento.ClientesCadastro;
import TelasFaturamento.ClientesConsulta;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.ValidarCpfCnpj;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 @author Paulo e Tiago
 */
public class InformarCPFouCNPJ extends javax.swing.JFrame {
    //String
    String sql           = "";
    String fatal         = "";
    String mensagem      = "";
    String FatalAbertura = "N";
    
    //boolean
    boolean ValidadorCpfCnpj    = false;
    
    //Bean
    private BeanClientes      bc    = new BeanClientes();
    private BeanCaixaAbertura bca   = new BeanCaixaAbertura();
    
    //Vetores
    ArrayList            parametros    = new ArrayList();
    ArrayList<ArrayList> dadosCliente  = new ArrayList();
    ArrayList<ArrayList> dadosCaixa    = new ArrayList();
    
    //Especiais
    ValidarCpfCnpj   Vcc     = new ValidarCpfCnpj();
    InverterData     invdata = new InverterData();
    CapturarDataHora cdh     = new CapturarDataHora();
    
    //Telas
    AberturaDeCaixa     AberDeCaixa;
    ClientesCadastro    CadCli;
    ClientesConsulta    ConCli;
    PDV                 Pdv;
    
    public InformarCPFouCNPJ(){
        initComponents();
    }
    
    private void VerificaCaixaFechado(){
        fatal = "N";
        bca.dataAbertura        = invdata.inverterData(cdh.CapturarData(), 2);
        sql = "select * from tb_caixa_abertura where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosCaixa.clear();
        dadosCaixa = parametrosNS.dao.Consulta(sql);
        if(dadosCaixa.isEmpty())
            return;
        sql = "select * from tb_caixa_abertura where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoComputador = " + parametrosNS.bcomp.codigoComputador + " and dataAbertura = '" + bca.dataAbertura + "' and status = 'Z';";
        dadosCaixa.clear();
        dadosCaixa = parametrosNS.dao.Consulta(sql);
        if(dadosCaixa.isEmpty())
            return;
        fatal = "S";
        mensagem = "Caixa Fechado com Redução Z!";
        new MostraMensagem(mensagem);
    }
    
    private void VerificaCaixaAberto(){
        FatalAbertura = "N";
        bca.codigoComputador    = parametrosNS.bcomp.codigoComputador;
        bca.dataAbertura        = invdata.inverterData(cdh.CapturarData(), 2);
        sql = "select * from tb_caixa_abertura where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoComputador = " + bca.codigoComputador + " and status = 'A';";
        dadosCaixa.clear();
        dadosCaixa = parametrosNS.dao.Consulta(sql);
        if(!dadosCaixa.isEmpty())
            return;
        FatalAbertura = "S";
        if(JOptionPane.showConfirmDialog(null, "Não foi encontrado Caixa Aberto para esse Terminal, deseja abri-lo?", "", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
            return;
        AberDeCaixa = new AberturaDeCaixa();
        AberDeCaixa.Modo = "Venda";
        AberDeCaixa.setVisible(true);
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        radio_Fisica = new javax.swing.JRadioButton();
        radio_Juridica = new javax.swing.JRadioButton();
        txt_cpf = new javax.swing.JFormattedTextField();
        txt_cnpj = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        bt_confirma = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informar CPF ou CNPJ");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Informar CPF ou CNPJ");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(radio_Fisica);
        radio_Fisica.setSelected(true);
        radio_Fisica.setText("Física");
        radio_Fisica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radio_FisicaItemStateChanged(evt);
            }
        });
        radio_Fisica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                radio_FisicaKeyPressed(evt);
            }
        });

        buttonGroup1.add(radio_Juridica);
        radio_Juridica.setText("Júridica");
        radio_Juridica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radio_JuridicaItemStateChanged(evt);
            }
        });
        radio_Juridica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                radio_JuridicaKeyPressed(evt);
            }
        });

        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cpfFocusLost(evt);
            }
        });
        txt_cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cpfKeyPressed(evt);
            }
        });

        txt_cnpj.setEditable(false);
        try {
            txt_cnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cnpj.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cnpj.setFocusable(false);
        txt_cnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cnpjFocusLost(evt);
            }
        });
        txt_cnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cnpjKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Pessoa:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radio_Juridica)
                    .addComponent(radio_Fisica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_cnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(txt_cpf))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {radio_Fisica, radio_Juridica});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radio_Fisica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cpf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(radio_Juridica, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cnpj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {radio_Fisica, radio_Juridica, txt_cnpj, txt_cpf});

        bt_confirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_confirma.setText("Confirmar");
        bt_confirma.setEnabled(false);
        bt_confirma.setFocusable(false);
        bt_confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmaActionPerformed(evt);
            }
        });
        bt_confirma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_confirmaKeyPressed(evt);
            }
        });

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_confirma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_confirma, bt_sair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        VerificaCaixaFechado();
        if(fatal.equals("S"))
            return;
        VerificaCaixaAberto();
        if(FatalAbertura.equals("S"))
            return;
        if(JOptionPane.showConfirmDialog(null, "Cliente cadastrado?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            parametrosNS.codigoCliente = 0;
            parametrosNS.cpfCnpj       = "";
            ConCli = new ClientesConsulta("N");
            ConCli.setVisible(true);
            dispose();
            return;
        }
        if(JOptionPane.showConfirmDialog(null, "Deseja informar o CPF ou CNPJ?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            return;
        parametrosNS.codigoCliente = 0;
        parametrosNS.cpfCnpj       = "";
        CadCli = new ClientesCadastro("N", 0);
        CadCli.Modo = "Venda";
        CadCli.setVisible(true);
        dispose();
    }//GEN-LAST:event_formWindowOpened

    private void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        AbrePdv();
    }//GEN-LAST:event_bt_confirmaActionPerformed

    private void radio_FisicaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radio_FisicaItemStateChanged
        HabilitaCampos();
    }//GEN-LAST:event_radio_FisicaItemStateChanged

    private void radio_JuridicaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radio_JuridicaItemStateChanged
        HabilitaCampos();
    }//GEN-LAST:event_radio_JuridicaItemStateChanged

    private void txt_cpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpfFocusLost
        ValidaCPFCNPJ();
    }//GEN-LAST:event_txt_cpfFocusLost

    private void txt_cnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cnpjFocusLost
        ValidaCPFCNPJ();
    }//GEN-LAST:event_txt_cnpjFocusLost

    private void radio_FisicaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_radio_FisicaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_cpf.grabFocus();
            if(txt_cpf.isEditable() == false)
                bt_confirma.grabFocus();
        }
        if(evt.getKeyCode() == KeyEvent.VK_DOWN)
            radio_Juridica.setSelected(true);
    }//GEN-LAST:event_radio_FisicaKeyPressed

    private void txt_cpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            bt_sair.grabFocus();
        if(evt.getKeyCode() == KeyEvent.VK_DOWN)
            radio_Juridica.setSelected(true);
    }//GEN-LAST:event_txt_cpfKeyPressed

    private void radio_JuridicaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_radio_JuridicaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_cnpj.grabFocus();
            if(txt_cnpj.isEditable() == false)
                bt_confirma.grabFocus();
        }
        if(evt.getKeyCode() == KeyEvent.VK_UP)
            radio_Fisica.setSelected(true);
    }//GEN-LAST:event_radio_JuridicaKeyPressed

    private void txt_cnpjKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cnpjKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            bt_sair.grabFocus();
        if(evt.getKeyCode() == KeyEvent.VK_UP)
            radio_Fisica.setSelected(true);
    }//GEN-LAST:event_txt_cnpjKeyPressed

    private void bt_confirmaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_confirmaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            AbrePdv();
    }//GEN-LAST:event_bt_confirmaKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton bt_sair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton radio_Fisica;
    private javax.swing.JRadioButton radio_Juridica;
    private javax.swing.JFormattedTextField txt_cnpj;
    private javax.swing.JFormattedTextField txt_cpf;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void HabilitaCampos(){
        txt_cpf .setText     ("");
        txt_cpf .setEditable (false);
        txt_cpf .setFocusable(false);
        txt_cnpj.setText     ("");
        txt_cnpj.setEditable (false);
        txt_cnpj.setFocusable(false);
        if(radio_Fisica.isSelected()){
            txt_cpf .setEditable(true);
            txt_cpf .setFocusable(true);
            txt_cpf .grabFocus();
            return;
        }
        if(radio_Juridica.isSelected()){
            txt_cnpj.setEditable(true);
            txt_cnpj.setFocusable(true);
            txt_cnpj.grabFocus();
            return;
        }
    }
    
    private void ValidaCPFCNPJ(){
        if(radio_Fisica.isSelected()){
            bc.cpfCnpj  = txt_cpf.getText();
            bc.cpfCnpj  = bc.cpfCnpj.replace(" ", "");
            bc.cpfCnpj  = bc.cpfCnpj.replace(".", "");
            bc.cpfCnpj  = bc.cpfCnpj.replace("-", "");
            mensagem = "CPF  inválido!";
        }else{
            bc.cpfCnpj  = txt_cnpj.getText();
            bc.cpfCnpj  = bc.cpfCnpj.replace(" ", "");
            bc.cpfCnpj  = bc.cpfCnpj.replace(".", "");
            bc.cpfCnpj  = bc.cpfCnpj.replace("/", "");
            bc.cpfCnpj  = bc.cpfCnpj.replace("-", "");
            mensagem = "CNPJ inválido!";
        }
        if(bc.cpfCnpj.equals(""))
            return;
        ValidadorCpfCnpj = Vcc.VALIDARCPFCNPJ(bc.cpfCnpj);
        if(ValidadorCpfCnpj == false){
            mostraMensagem();
            return;
        }
        bt_confirma.setEnabled  (true);
        bt_confirma.setFocusable(true);
        bt_confirma.grabFocus();
    }
    
    private void AbrePdv(){
        parametrosNS.codigoCliente = 99999;
        parametrosNS.cpfCnpj       = bc.cpfCnpj;
        dispose();
    }
}
