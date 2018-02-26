package Crud;

import Beans.BeanCrud;
import Parametros.parametrosNS;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 @author Tiago e Paulo 
 */
public class CrudConsulta extends javax.swing.JFrame {
    //String
    String sql          = "";
    String mensagem     = "";
    String retorno      = "";
    String somostra     = "";
    
    //int
    int linha   = 0;
    
    //Vetores
    ArrayList<ArrayList> dadosCrud  = new ArrayList();
    
    //Bean
    BeanCrud bcrud = new BeanCrud();
    
    //Especiais
    DefaultTableModel Tabela;
    
    //Telas
    Crud crud;
    
    public CrudConsulta(String Somostra){
        somostra = Somostra;
        initComponents();
    }
    
    private void PegaCrud(){
        sql = "select * from tb_crud";
        dadosCrud.clear();
        dadosCrud = parametrosNS.dao.Consulta(sql);
        if(dadosCrud.isEmpty())
            return;
        PegaDadosCrud();
    }
    
    private void PegaDadosCrud(){
        String selecionada  = "";
        String radioBox     = "";
        
        for(int i = 0; i < dadosCrud.size(); i++){
            bcrud = new BeanCrud();
            if(dadosCrud.get(i).get(0) != null)
                bcrud.idExemplo              = Integer.parseInt(  String.valueOf(dadosCrud.get(i).get(0)));
            if(dadosCrud.get(i).get(1) != null)
                bcrud.intExemplo             = Integer.parseInt(  String.valueOf(dadosCrud.get(i).get(1)));
            if(dadosCrud.get(i).get(2) != null)
                bcrud.comboExemplo           = Integer.parseInt(  String.valueOf(dadosCrud.get(i).get(2)));
            if(dadosCrud.get(i).get(3) != null)
                bcrud.textoExemplo           =                    String.valueOf(dadosCrud.get(i).get(3));
            if(dadosCrud.get(i).get(4) != null)
                bcrud.valorExemplo           = Double.parseDouble(String.valueOf(dadosCrud.get(i).get(4)));
            if(dadosCrud.get(i).get(5) != null)
                bcrud.checkBox               = Integer.parseInt(  String.valueOf(dadosCrud.get(i).get(5)));
            if(dadosCrud.get(i).get(6) != null)
                bcrud.radioBoxCpfCnpjExemplo = Integer.parseInt(  String.valueOf(dadosCrud.get(i).get(6)));
            if(dadosCrud.get(i).get(7) != null)
                bcrud.cpfExemplo             =                    String.valueOf(dadosCrud.get(i).get(7));
            if(dadosCrud.get(i).get(8) != null)
                bcrud.cnpjExemplo            =                    String.valueOf(dadosCrud.get(i).get(8));
            
            switch(bcrud.checkBox){
                case 0: selecionada = String.valueOf(bcrud.checkBox) + " - Não";break;
                case 1: selecionada = String.valueOf(bcrud.checkBox) + " - Sim";break;
            }
            
            switch(bcrud.radioBoxCpfCnpjExemplo){
                case 0: radioBox = String.valueOf(bcrud.radioBoxCpfCnpjExemplo) + " - Física"  ;break;
                case 1: radioBox = String.valueOf(bcrud.radioBoxCpfCnpjExemplo) + " - Jurídica";break;
            }
            
            if(!bcrud.cpfExemplo.equals(""))
                bcrud.cpfExemplo    = parametrosNS.FCpfCnpj.FormataCPFCNPJ(bcrud.cpfExemplo);
            
            if(!bcrud.cnpjExemplo.equals(""))
                bcrud.cnpjExemplo   = parametrosNS.FCpfCnpj.FormataCPFCNPJ(bcrud.cnpjExemplo);
            
            Tabela.addRow(new Object[] {parametrosNS.fc.FormataCampo(String.valueOf(bcrud.idExemplo), 3, 0), parametrosNS.fc.FormataCampo(String.valueOf(bcrud.intExemplo), 3, 0), "Combo index:" + bcrud.comboExemplo, bcrud.textoExemplo, parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bcrud.valorExemplo), 0), "Selecionada: " + selecionada, radioBox, bcrud.cpfExemplo, bcrud.cnpjExemplo});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPopup = new javax.swing.JPopupMenu();
        bt_detalhes = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_crud = new javax.swing.JTable();
        txt_texto = new javax.swing.JTextField();

        bt_detalhes.setText("Detalhes");
        bt_detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_detalhesActionPerformed(evt);
            }
        });
        MenuPopup.add(bt_detalhes);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tabela_crud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idExemplo", "intExemplo", "comboExemplo", "textoExemplo", "valorExemplo", "checkBox", "radioBoxCpfCnpj", "cpfExemplo", "nullcnpjExemplo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_crud.getTableHeader().setReorderingAllowed(false);
        tabela_crud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_crudMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_crud);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
                    .addComponent(txt_texto))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Tabela = (DefaultTableModel)tabela_crud.getModel();
        PegaCrud();
    }//GEN-LAST:event_formWindowOpened

    private void tabela_crudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_crudMouseClicked
        linha = tabela_crud.getSelectedRow();
        if(linha < 0){
            mensagem = "Item não selecionado!";
            mostraMensagem();
            return;
        }
        if(evt.getButton() == MouseEvent.BUTTON3)
            if(somostra.equalsIgnoreCase("N"))
                MenuPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        retorno = String.valueOf(Integer.parseInt(String.valueOf(tabela_crud.getValueAt(linha, 0))));
        if(evt.getClickCount() < 2)
            return;
        dispose();
    }//GEN-LAST:event_tabela_crudMouseClicked

    private void bt_detalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_detalhesActionPerformed
        if(crud != null)
            if(crud.isVisible()){
                crud.setState(JFrame.NORMAL);
                return;
            }
        crud = new Crud(Integer.parseInt(retorno));
        crud.setVisible(true);
    }//GEN-LAST:event_bt_detalhesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuPopup;
    private javax.swing.JMenuItem bt_detalhes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_crud;
    private javax.swing.JTextField txt_texto;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public String getRetorno(){
        return retorno;
    }
    
}
