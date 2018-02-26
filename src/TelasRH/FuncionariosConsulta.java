package TelasRH;

import Beans.BeanDepartamento;
import Beans.BeanFuncionarios;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * @author Tiago
 */
public class FuncionariosConsulta extends javax.swing.JFrame {
    //String 
    String sql        = "";
    String mensagem   = "";
    String somostra   = "";
    String textoBusca = "";
    String retorno    = "";
    
    //int's
    int index   = 0;
    int linha   = 0;
    
    //Vetores
    ArrayList            parametros         = new ArrayList();
    ArrayList            dadosPadroes       = new ArrayList();
//    ArrayList<ArrayList> dadosDepartamento  = new ArrayList();
    ArrayList<ArrayList> dadosFuncionarios  = new ArrayList();
    
    //Beans
    BeanDepartamento bdep  = new BeanDepartamento();
    BeanFuncionarios bfunc = new BeanFuncionarios();
    
    //Especiais
    DefaultTableModel    TableFuncionarios;
    FuncionariosCadastro FunCad;
    
    public FuncionariosConsulta(String SoMostra){
        somostra                = SoMostra;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhes = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_funcionarios = new javax.swing.JTable();
        txt_descricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        bt_detalhes.setText("Detalhes");
        bt_detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhes);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Funcionários");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Consulta Funcionários");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_funcionarios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_funcionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Código", "Nome", "CPF ou CNPJ", "Departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_funcionarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_funcionarios.getTableHeader().setReorderingAllowed(false);
        tabela_funcionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_funcionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_funcionarios);
        if (tabela_funcionarios.getColumnModel().getColumnCount() > 0) {
            tabela_funcionarios.getColumnModel().getColumn(0).setResizable(false);
            tabela_funcionarios.getColumnModel().getColumn(1).setPreferredWidth(70);
            tabela_funcionarios.getColumnModel().getColumn(2).setPreferredWidth(350);
        }

        txt_descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descricaoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                    .addComponent(txt_descricao))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel5.setText("Total: ");

        txt_total.setEditable(false);

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 697, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TableFuncionarios = (DefaultTableModel)tabela_funcionarios.getModel();
        
        PegaFuncionarios();
    }//GEN-LAST:event_formWindowOpened

    private void txt_descricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descricaoKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_CAPS_LOCK)
            return;
        if(evt.getKeyCode() == KeyEvent.VK_SHIFT)
            return;
        textoBusca = txt_descricao.getText();
        if(textoBusca.equals("")){
            index = 0;
            PegaFuncionarios();
            return;
        }
        index = 1;
        PegaFuncionarios();
    }//GEN-LAST:event_txt_descricaoKeyReleased

    private void tabela_funcionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_funcionariosMouseClicked
        if(tabela_funcionarios.isEnabled() == false)
            return;
        linha = tabela_funcionarios.getSelectedRow();
        if(linha < 0){
            mensagem = "Item não selecionado!";
            new MostraMensagem(mensagem);
            return;
        }
        if(evt.getButton() == MouseEvent.BUTTON3)
            if(somostra.equals("N"))
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_funcionarios.getValueAt(linha, 0))));
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_funcionariosMouseClicked

    private void bt_detalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesActionPerformed
        if(FunCad != null)if(FunCad.isVisible()){
            mensagem = "Tela já aberta!";
            new MostraMensagem(mensagem);
            return;
        }
        FunCad = new FuncionariosCadastro("S", Integer.parseInt(retorno));
        FunCad.setVisible(true);
    }//GEN-LAST:event_bt_detalhesActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_detalhes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_funcionarios;
    private javax.swing.JTextField txt_descricao;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
    private void PegaFuncionarios() {
        sql  = "select \n" +
               "  fun.idFuncionario, \n" +
               "  fun.idEmpresa, \n" +
               "  fun.codigoGrupo, \n" +
               "  fun.codigoEmpresa, \n" +
               "  fun.codigoFuncionario, \n" +
               "  fun.nomeFuncionario, \n" +
               "  fun.cpfCnpj, \n" +
               "  fun.codigoDepartamento, \n" +
               "  dep.descricaoDepartamento, \n" +
               "  fun.dataNascimento \n" +
               "from\n" +
               "  tb_funcionarios fun \n" +
               "  inner join tb_departamento dep on ((fun.idEmpresa = dep.idEmpresa) and (fun.codigoDepartamento = dep.codigoDepartamento)) \n";
        if(parametrosNS.bu.codigoDepartamento != 999)
            sql += "    where fun.codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and fun.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa;
        if(parametrosNS.bu.codigoDepartamento == 999)
            sql += "    where fun.codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and fun.codigoEmpresa = " + parametrosNS.be.CodigoEmpresa;
        switch(index){
            case 1: sql += " and fun.codigoFuncionario like '%"     + textoBusca + "%'"; break;
            case 2: sql += " and fun.nomeFuncionario like '%"       + textoBusca + "%'"; break;
            case 3: sql += " and fun.cpfCnpj like '%"               + textoBusca + "%'"; break;
            case 4: sql += " and dep.codigoDepartamento like '%"    + textoBusca + "%'"; break;
            case 5: sql += " and dep.descricaoDepartamento like '%" + textoBusca + "%'"; break;
        }
        sql += " order by fun.idFuncionario asc;";
        dadosFuncionarios.clear();
        dadosFuncionarios = parametrosNS.dao.Consulta(sql);
        if(dadosFuncionarios.isEmpty()){
            index++;
            if(index < 6){
                PegaFuncionarios();
                return;
            }
        }
        PreencherTabelaFuncionarios();
    }

    private void PreencherTabelaFuncionarios(){
        tabela_funcionarios.getColumnModel().getColumn(0).setMaxWidth(0);//Ocultar a CI de controle 07/08/2017
        tabela_funcionarios.getColumnModel().getColumn(0).setMinWidth(0);
        tabela_funcionarios.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tabela_funcionarios.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        tabela_funcionarios.getColumnModel().getColumn(1).setResizable(false);
        tabela_funcionarios.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabela_funcionarios.getColumnModel().getColumn(2).setResizable(false);
        tabela_funcionarios.getColumnModel().getColumn(2).setPreferredWidth(225);
        tabela_funcionarios.getColumnModel().getColumn(3).setResizable(false);
        tabela_funcionarios.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabela_funcionarios.getColumnModel().getColumn(4).setResizable(false);
        tabela_funcionarios.getColumnModel().getColumn(4).setPreferredWidth(150);
        
        TableFuncionarios.setNumRows(0);
        for(int i = 0; i < dadosFuncionarios.size(); i++){
            if(dadosFuncionarios.get(i).get(0) != null)
            bfunc.idFuncionario         = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(0)));
            if(dadosFuncionarios.get(i).get(1) != null)
            bfunc.idEmpresa             = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(1)));
            if(dadosFuncionarios.get(i).get(2) != null)
            bfunc.codigoGrupo           = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(2)));
            if(dadosFuncionarios.get(i).get(3) != null)
            bfunc.codigoEmpresa         = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(3)));
            if(dadosFuncionarios.get(i).get(4) != null)
            bfunc.codigoFuncionario     = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(4)));
            bfunc.nomeFuncionario       =                  String.valueOf(dadosFuncionarios.get(i).get(5));
            bfunc.cpfCnpj               =                  String.valueOf(dadosFuncionarios.get(i).get(6));
            if(dadosFuncionarios.get(i).get(7) != null)
            bfunc.codigoDepartamento    = Integer.parseInt(String.valueOf(dadosFuncionarios.get(i).get(7)));
            
            bdep.idEmpresa              = bfunc.idEmpresa;
            bdep.codigoGrupo            = bfunc.codigoGrupo;
            bdep.codigoEmpresa          = bfunc.codigoEmpresa;
            bdep.codigoDepartamento     = bfunc.codigoDepartamento;
            bdep.descricaoDepartamento  =                  String.valueOf(dadosFuncionarios.get(i).get(8));
            
            bfunc.cpfCnpj   = parametrosNS.FCpfCnpj.FormataCPFCNPJ(bfunc.cpfCnpj);
            
            bdep.descricaoDepartamento  = parametrosNS.fc.FormataCampo(String.valueOf(bdep.codigoDepartamento), 2, 0) + "-" + bdep.descricaoDepartamento;
            
            bfunc.dataNascimento        =                  String.valueOf(dadosFuncionarios.get(i).get(9));
            bfunc.dataNascimento        = parametrosNS.invdata.inverterData(bfunc.dataNascimento, 1);
            
            TableFuncionarios.addRow(new Object [] {parametrosNS.fc.FormataCampo(String.valueOf(bfunc.idFuncionario), 6, 0), parametrosNS.fc.FormataCampo(String.valueOf(bfunc.codigoFuncionario), 6, 0), bfunc.nomeFuncionario, bfunc.cpfCnpj, bdep.descricaoDepartamento});
        }
    }
}
