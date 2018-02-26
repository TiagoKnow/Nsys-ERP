package FuncoesInternas;

import BeansNS.BeanCEP;
import Beans.*;
import Dao.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/*
 @author Tiago e Paulo
 */
public class AjustarCep extends javax.swing.JFrame {
    //Connection's
    Connection con;
    
    //String's
    String sql                  = "";
    String sqlstate             = "00000";
    String fatal                = "";
    String Mensagem             = "";
    
    //int's
    int    UltimoCEP            = 0;
    
    //Vetores
    ArrayList dadosCEP          = new ArrayList();
    
    //Dao's
    DaoMySQL dao;
    
    //Bean's
    BeanCEP         bcep        = new BeanCEP();
    
    public AjustarCep(Connection con1){
        initComponents();
        con                 = con1;
        
//        dao                 = new Dao(con);
        
        sql = "select count(*) from ns_cep;";
        
//        UltimoCEP = dao.ConsultaCount(sql);
        BarraCep.setMaximum(UltimoCEP);
        TotalCEP.setText("/ " + String.valueOf(UltimoCEP));
    }
    
    private void CarregarCEPs(){
        sql = "select * from ns_cep;";
        dadosCEP.clear();
//        dadosCEP = dao.ConsultaCEP(sql);
        if(!dadosCEP.isEmpty())
            return;
        Mensagem = "Não existem CEP's cadastrados!";
        new MostraMensagem(Mensagem);
        fatal = "S";
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_executar = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        BarraCep = new javax.swing.JProgressBar();
        txt_cep = new javax.swing.JLabel();
        TotalCEP = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ComboBanco = new javax.swing.JComboBox();
        Combo_funcao = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bt_executar.setText("Executar");
        bt_executar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_executarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Progresso"));

        txt_cep.setText("000000");

        TotalCEP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TotalCEP.setText("000000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraCep, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_cep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cep)
                    .addComponent(TotalCEP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BarraCep, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Fabrica de Conexão"));

        ComboBanco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Local", "Remoto" }));
        ComboBanco.setEnabled(false);

        Combo_funcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Adicionar (-)", "Remover (-)"}));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(ComboBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Combo_funcao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(ComboBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Combo_funcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_executar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_executar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void bt_executarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_executarActionPerformed
        if(Combo_funcao.getSelectedIndex() == 0){
            Mensagem = "Função não selecionada!";
            new MostraMensagem(Mensagem);
            return;
        }
        bt_executar.setEnabled(false);
        CarregarCEPs();
        if(fatal.equals("S"))
            return;
        new Thread(){
            public void run(){
                AlteraCEP();
            }
        }.start();
        bt_executar.setEnabled(true);
    }//GEN-LAST:event_bt_executarActionPerformed
    
    private void AlteraCEP(){
        for(int i = 0; i < dadosCEP.size(); i++){
            sqlstate = "00000";
            fatal = "N";
            bcep.idCep  = ((BeanCEP)(dadosCEP.get(i))).idCep;
            bcep.cep    = ((BeanCEP)(dadosCEP.get(i))).cep;
            VerificaCondicao();
            
            sql = "update ns_cep set cep = '" + bcep.cep + "' where idCEP = '" + bcep.idCep + "';";
            if(fatal.equals("N")){
                sqlstate = dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
            }
            if(!sqlstate.equals("00000")){
                Mensagem = "Erro ao atualizar CEP " + bcep.cep + "!";
                new MostraMensagem(Mensagem);
            }
            txt_cep.setText(String.valueOf(bcep.idCep));

            SetaValorNaBarra();
        }
    }
    
    private void VerificaCondicao(){
        if(Combo_funcao.getSelectedIndex() == 1){
            if(bcep.cep.length() < 9){
                bcep.cep = bcep.cep.substring(0, 5) + "-" + bcep.cep.substring(5, 8);
                return;
            }
            fatal = "S";
        }
        if(Combo_funcao.getSelectedIndex() == 2){
            if(bcep.cep.length() > 8){
                bcep.cep = bcep.cep.substring(0, 5) + bcep.cep.substring(6, 9);
                return;
            }
            fatal = "S";
        }
    }
    
    private void SetaValorNaBarra(){
        BarraCep.setValue(bcep.idCep);
        BarraCep.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar BarraCep;
    private javax.swing.JComboBox ComboBanco;
    private static javax.swing.JComboBox Combo_funcao;
    private javax.swing.JLabel TotalCEP;
    private javax.swing.JToggleButton bt_executar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txt_cep;
    // End of variables declaration//GEN-END:variables
    
    
}
