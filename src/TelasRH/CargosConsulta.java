package TelasRH;

import Beans.BeanFuncionariosCargo;
import FuncoesInternas.InverterData;
//import Parametros.parametros;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Tiago
 */
public class CargosConsulta extends javax.swing.JFrame {
    //Int
    int totalRegistros = 0;
    int linha          = 0;
    int coluna         = 0;
    int registro       = 0;
    
    //String
    String mensagem     = "";
    String sql          = "";
    String parametro    = "";
    String tipoPesquisa = "";
    
    //Vetores
    ArrayList<ArrayList> dadosAlunos = new ArrayList();
    
    //DefaultTableModel
    DefaultTableModel tb;
    
    //Funções
    InverterData aj = new InverterData();
    
    //Beans
    BeanFuncionariosCargo bfc = new BeanFuncionariosCargo(); // ba = Barry Allen :)
    
    public CargosConsulta() {
        initComponents();
        tb = (DefaultTableModel)tabela.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_2 = new javax.swing.JPanel();
        txt_parametroPesquisa = new javax.swing.JTextField();
        bt_buscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        combo_tipoPesquisa = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_totalRegistros = new javax.swing.JTextField();
        check_inativos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de alunos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        painel_2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_parametroPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_parametroPesquisaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_parametroPesquisaFocusLost(evt);
            }
        });
        txt_parametroPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_parametroPesquisaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_parametroPesquisaKeyReleased(evt);
            }
        });

        bt_buscar.setText("Buscar");
        bt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscarActionPerformed(evt);
            }
        });
        bt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_buscarKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Localizar alunos");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Forma de Pesquisa: ");

        combo_tipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        combo_tipoPesquisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_tipoPesquisaItemStateChanged(evt);
            }
        });

        jLabel6.setText("Parâmetro: ");

        javax.swing.GroupLayout painel_2Layout = new javax.swing.GroupLayout(painel_2);
        painel_2.setLayout(painel_2Layout);
        painel_2Layout.setHorizontalGroup(
            painel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_tipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_parametroPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_buscar)
                .addContainerGap())
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painel_2Layout.setVerticalGroup(
            painel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_buscar)
                    .addComponent(txt_parametroPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(combo_tipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        tabela.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Aluno", "Endereço", "CEP", "Bairro", "Cidade", "UF", "Paróquia", "Unidade", "Escolaridade", "RG", "CPF", "Inativo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        tabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tabela);

        jLabel1.setText("Total de registros: ");

        txt_totalRegistros.setEditable(false);

        check_inativos.setText("Exibir os alunos inativos");
        check_inativos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check_inativosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 915, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_totalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(check_inativos)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_totalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_inativos))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_parametroPesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_parametroPesquisaFocusGained

    }//GEN-LAST:event_txt_parametroPesquisaFocusGained

    private void txt_parametroPesquisaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_parametroPesquisaFocusLost

    }//GEN-LAST:event_txt_parametroPesquisaFocusLost

    private void txt_parametroPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_parametroPesquisaKeyPressed

    }//GEN-LAST:event_txt_parametroPesquisaKeyPressed

    private void bt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscarActionPerformed
        tipoPesquisa = String.valueOf(combo_tipoPesquisa.getSelectedItem());
        parametro = txt_parametroPesquisa.getText();
        try {
            if(tipoPesquisa.equals("---------------------")){
                mensagem = "Favor, selecione um tipo de pesquisa";
                mostraMensagem();
                return;
            }else{
                if(tipoPesquisa.equals("Descrição")){
                    sql = "select * from tb_empresas where nomeUnidade like ('%"+parametro+"%')";
                }else if(tipoPesquisa.equals("Todos")){
//                    sql = "select * from tb_caixa_banco where codigoEmpresa = '"+parametros.codigoEmpresa+"'";
                }
                carregaValores();
                preencherTabela();
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no botão Buscar!" + e);
        }
    }//GEN-LAST:event_bt_buscarActionPerformed

    private void bt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_buscarKeyPressed

    }//GEN-LAST:event_bt_buscarKeyPressed

    private void combo_tipoPesquisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_tipoPesquisaItemStateChanged
        tipoPesquisa = String.valueOf(combo_tipoPesquisa.getSelectedItem());
    }//GEN-LAST:event_combo_tipoPesquisaItemStateChanged

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if(evt.getClickCount() == 2){

            linha  = tabela.getSelectedRow();
            coluna = tabela.getSelectedColumn();
            try{
                registro = Integer.parseInt(String.valueOf(tabela.getValueAt(linha, 0)));
            }catch(Exception e){
                System.out.println(e);
            }
            dispose();
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void tabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyReleased

    }//GEN-LAST:event_tabelaKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        combo_tipoPesquisa.addItem("Nome do aluno");
        sql = "select * from tb_alunos where Inativo <> '1' order by CodAluno desc";
        carregaValores();
        preencherTabela();
        combo_tipoPesquisa.setSelectedIndex(1);
    }//GEN-LAST:event_formWindowOpened

    private void txt_parametroPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_parametroPesquisaKeyReleased
        parametro = txt_parametroPesquisa.getText();
        tipoPesquisa = String.valueOf(combo_tipoPesquisa.getSelectedItem());
        
        if(tipoPesquisa.equals("Nome do aluno")){
            sql = "select * from tb_alunos where Nome like ('%"+parametro+"%') order by CodAluno asc";
        }
        carregaValores();
        preencherTabela();
    }//GEN-LAST:event_txt_parametroPesquisaKeyReleased

    private void check_inativosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_check_inativosItemStateChanged
        if(check_inativos.isSelected()){
            sql = "select * from tb_alunos order by CodAluno desc";
            carregaValores();
            preencherTabela();
        }else{
            sql = "select * from tb_alunos where Inativo <> '1' order by CodAluno desc";
            carregaValores();
            preencherTabela();
        }
        
    }//GEN-LAST:event_check_inativosItemStateChanged



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_buscar;
    private javax.swing.JCheckBox check_inativos;
    private javax.swing.JComboBox<String> combo_tipoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel painel_2;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txt_parametroPesquisa;
    private javax.swing.JTextField txt_totalRegistros;
    // End of variables declaration//GEN-END:variables

    private void mostraMensagem() {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void carregaValores() {
//        dadosAlunos = parametros.oprMySQL.consulta(sql);
        if(dadosAlunos.isEmpty()){
            mensagem = "Nenhum aluno localizado";
            mostraMensagem();
            return;
        }
    }
    
    private void preencherTabela() {
        try{
            tb.setNumRows(0);
//            ba = new BeanAlunos();//Barry Alleen
            
            tabela.getColumnModel().getColumn(0).setPreferredWidth(35); 
            tabela.getColumnModel().getColumn(1).setPreferredWidth(350); 
            tabela.getColumnModel().getColumn(2).setPreferredWidth(90); 
            tabela.getColumnModel().getColumn(3).setPreferredWidth(130); 
            tabela.getColumnModel().getColumn(4).setPreferredWidth(80); 
            tabela.getColumnModel().getColumn(5).setPreferredWidth(80); 
            tabela.getColumnModel().getColumn(6).setPreferredWidth(80); 
            tabela.getColumnModel().getColumn(7).setPreferredWidth(80); 

            for (int i = 0; i < dadosAlunos.size(); i++){
//                ba = new BeanAlunos();
//                ba.CodAluno     = Integer.parseInt((String) dadosAlunos.get(i).get(0));
//                ba.Nome         =                  (String) dadosAlunos.get(i).get(1);
//                ba.Endereco     =                  (String) dadosAlunos.get(i).get(2);
//                ba.CEP          =                  (String) dadosAlunos.get(i).get(4);
//                ba.Bairro       =                  (String) dadosAlunos.get(i).get(5);
//                ba.Cidade       =                  (String) dadosAlunos.get(i).get(6);
//                ba.Estado       =                  (String) dadosAlunos.get(i).get(7);
//                ba.Paróquia     =                  (String) dadosAlunos.get(i).get(8);
//                ba.Unidade      =                  (String) dadosAlunos.get(i).get(9);
//                ba.Escolaridade =                  (String) dadosAlunos.get(i).get(12);
//                ba.RG           =                  (String) dadosAlunos.get(i).get(18);
//                ba.CPF          =                  (String) dadosAlunos.get(i).get(45);
                                
                //ba.dataAbertura       = aj.inverterData(ba.dataAbertura, 1);
                
                //ba.cnpjEmpresa = f.FormataCPFCNPJ(ba.cnpjEmpresa);
                
                totalRegistros        = i + 1;

//                tb.addRow(new Object [] {ba.CodAluno, ba.Nome, ba.Endereco, ba.CEP, ba.Bairro, ba.Cidade, ba.Estado, ba.Paróquia, ba.Unidade, ba.Escolaridade, ba.RG, ba.CPF});
            }
            txt_totalRegistros.setText(String.valueOf(totalRegistros));
        }catch(Exception erro){
            mensagem = "Erro: " + erro;
            mostraMensagem();
        }
    }
    
    public int getResultado(){
        return registro;
    }
}
