package Telas;

import Beans.BeanComputadores;
import Beans.BeanDepartamento;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import Parametros.parametrosNS;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 @author Paulo
 */
public class ComputadoresConsulta extends javax.swing.JFrame {
    //String's
    String sql      = "";
    String mensagem = "";
    String retorno  = "";
    
    //int's
    int index       = 0;
    int linha       = 0;
    
    //ArrayList's
    ArrayList<ArrayList> dadosComputadores     = new ArrayList();
    
    //Bean's
    BeanComputadores    bcomp   = new BeanComputadores();
    BeanDepartamento    bdep    = new BeanDepartamento();
    
    //Especiais
    FormataCampo        fc  = new FormataCampo();
    DefaultTableModel   TableComputadores;
    
    public ComputadoresConsulta() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_computadores = new javax.swing.JTable();
        txt_pesquisa = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de computadores");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta de Computadores");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_computadores.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_computadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Codigo", "Nome do Computador", "Departamento", "IP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_computadores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_computadores.getTableHeader().setReorderingAllowed(false);
        tabela_computadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_computadoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_computadores);
        if (tabela_computadores.getColumnModel().getColumnCount() > 0) {
            tabela_computadores.getColumnModel().getColumn(0).setMinWidth(0);
            tabela_computadores.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabela_computadores.getColumnModel().getColumn(0).setMaxWidth(0);
            tabela_computadores.getColumnModel().getColumn(1).setResizable(false);
            tabela_computadores.getColumnModel().getColumn(1).setPreferredWidth(45);
            tabela_computadores.getColumnModel().getColumn(2).setResizable(false);
            tabela_computadores.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabela_computadores.getColumnModel().getColumn(3).setResizable(false);
            tabela_computadores.getColumnModel().getColumn(3).setPreferredWidth(200);
            tabela_computadores.getColumnModel().getColumn(4).setResizable(false);
            tabela_computadores.getColumnModel().getColumn(4).setPreferredWidth(125);
        }

        txt_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addComponent(txt_pesquisa))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TableComputadores = (DefaultTableModel)tabela_computadores.getModel();
        index = 0;
        PegaComputadores();
    }//GEN-LAST:event_formWindowOpened

    private void txt_pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisaKeyReleased
        bcomp.nomeComputador    = txt_pesquisa.getText();
        if(bcomp.nomeComputador.equals("")){
            index = 0;
            PegaComputadores();
            return;
        }
        index = 1;
        PegaComputadores();
    }//GEN-LAST:event_txt_pesquisaKeyReleased

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void tabela_computadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_computadoresMouseClicked
        linha           = tabela_computadores.getSelectedRow();
        if(linha < 0){
            mensagem = "Item não selecionado!";
            new MostraMensagem(mensagem);
            return;
        }
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_computadores.getValueAt(linha, 0))));
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_computadoresMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_computadores;
    private javax.swing.JTextField txt_pesquisa;
    // End of variables declaration//GEN-END:variables
    
    public String getRetorno(){
        return retorno;
    }
    
    private void PegaComputadores(){
        sql = "select \n" +
            "  comp.idComputador, \n" +
            "  comp.codigoComputador, \n" +
            "  comp.nomeComputador, \n" +
            "  dep.codigoDepartamento, \n" +
            "  dep.descricaoDepartamento, \n" +
            "  comp.ipv4 \n" +
            "from \n" +
            "  tb_computadores comp \n" +
            "  inner join tb_departamento dep on ((comp.idEmpresa = dep.idEmpresa) and (comp.computadorDepartamento = dep.codigoDepartamento)) \n" +
            "    where comp.idEmpresa = " + parametrosNS.be.IdEmpresa + " ";
        switch(index){
            case 1: sql += "and comp.codigoComputador like '%"     + bcomp.nomeComputador + "%' "; break;
            case 2: sql += "and comp.nomeComputador like '%"       + bcomp.nomeComputador + "%' "; break;
            case 3: sql += "and dep.descricaoDepartamento like '%" + bcomp.nomeComputador + "%' "; break;
            case 4: sql += "and comp.ipv4 like '%"                 + bcomp.nomeComputador + "%' "; break;
        }
        sql += "order by comp.idComputador asc;";
        dadosComputadores.clear();
        dadosComputadores = parametrosNS.dao.Consulta(sql);
        if(dadosComputadores.isEmpty()){
            index++;
            if(index < 5){
                PegaComputadores();
                return;
            }
        }
        PegaDadosComputadores();
    }
    
    private void PegaDadosComputadores(){
        TableComputadores.setNumRows(0);
        for(int i = 0; i < dadosComputadores.size(); i++){
        if(dadosComputadores.get(i).get(0) != null)
            bcomp.idComputador          = Integer.parseInt( String.valueOf(dadosComputadores.get(i).get(0)));
        if(dadosComputadores.get(i).get(1) != null)
            bcomp.codigoComputador      = Integer.parseInt( String.valueOf(dadosComputadores.get(i).get(1)));
            bcomp.nomeComputador        =                   String.valueOf(dadosComputadores.get(i).get(2));
        if(dadosComputadores.get(i).get(3) != null)
            bdep .codigoDepartamento    = Integer.parseInt( String.valueOf(dadosComputadores.get(i).get(3)));
            bdep .descricaoDepartamento =                   String.valueOf(dadosComputadores.get(i).get(4));
            bcomp.ipv4                  =                   String.valueOf(dadosComputadores.get(i).get(5));
            
            if(bcomp.ipv4.equals("null"))
                bcomp.ipv4 = "";
            
            TableComputadores.addRow(new Object[] {bcomp.idComputador, fc.FormataCampo(String.valueOf(bcomp.codigoComputador), 2, 0), bcomp.nomeComputador, fc.FormataCampo(String.valueOf(bdep.codigoDepartamento), 2, 0) + "-" + bdep.descricaoDepartamento, bcomp.ipv4});
        }
    }
}
