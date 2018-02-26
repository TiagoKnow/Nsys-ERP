package TelasDeConfiguracoes;

import Beans.BeanDepartamento;
import Beans.BeanUsuarios;
import Dao.DaoMySQL;
import FuncoesInternas.*;
import Parametros.parametrosNS;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.table.*;
/*
 @author Tiago e Paulo
 */
public class GerenciadorDeConexoes extends javax.swing.JFrame {
    //String's
    String sql                      = "";
    String sqlstate                 = "";
    String Mensagem                 = "";
    String consultouPrimeiraVez     = "";
    
    //int's
    int    Linha                    = 0;
    int    codigoDepartamento       = 0;
    
    //Timer
    Timer Tempo;
    
    //ArrayList
    ArrayList<ArrayList> dadosUsuario          = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosDepartamentos    = new ArrayList<ArrayList>();
    
    //Especiais
    DefaultTableModel    Tabela;
    
    //Bean's
    BeanUsuarios        bu          = new BeanUsuarios();
    BeanDepartamento    bd          = new BeanDepartamento();
    
    //Telas
    
    //Especiais
    FormataCampo        fc          = new FormataCampo();
    
    public GerenciadorDeConexoes(){
        initComponents();
    }
    
    private void CarregarAutomaticamente(){
        bt_encerrarConexao.setEnabled(false);
        ActionListener action = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PegaUsuarios();
            }
        };
        Tempo = new Timer(5000, action);
        Tempo.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela_Conexoes = new javax.swing.JTable();
        bt_sair = new javax.swing.JButton();
        bt_encerrarConexao = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair1 = new javax.swing.JMenuItem();

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
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerenciador de Conexões");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Tabela_Conexoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuário", "Nome do Usuário", "Departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabela_Conexoes.getTableHeader().setReorderingAllowed(false);
        Tabela_Conexoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabela_ConexoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabela_Conexoes);
        if (Tabela_Conexoes.getColumnModel().getColumnCount() > 0) {
            Tabela_Conexoes.getColumnModel().getColumn(0).setResizable(false);
            Tabela_Conexoes.getColumnModel().getColumn(1).setResizable(false);
            Tabela_Conexoes.getColumnModel().getColumn(1).setPreferredWidth(230);
            Tabela_Conexoes.getColumnModel().getColumn(2).setResizable(false);
            Tabela_Conexoes.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        bt_encerrarConexao.setText("Encerrar Conexão");
        bt_encerrarConexao.setEnabled(false);
        bt_encerrarConexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_encerrarConexaoActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        bt_sair1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair1.setText("Sair");
        bt_sair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sair1ActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair1);

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bt_encerrarConexao)
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
                    .addComponent(bt_sair)
                    .addComponent(bt_encerrarConexao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_encerrarConexaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_encerrarConexaoActionPerformed
        bu.codigoUsuario = Integer.parseInt(String.valueOf(Tabela_Conexoes.getValueAt(Linha, 0)).substring(0, 3));
        sql = "update tb_usuarios set nomeConexao = null where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
//        System.out.println(sql);
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000"))
            return;
        PegaUsuarios();
        bt_encerrarConexao.setEnabled(false);
    }//GEN-LAST:event_bt_encerrarConexaoActionPerformed

    private void Tabela_ConexoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabela_ConexoesMouseClicked
        if(evt.getClickCount() < 2)
            return;
        bt_encerrarConexao.setEnabled(true);
        Linha = Tabela_Conexoes.getSelectedRow();
    }//GEN-LAST:event_Tabela_ConexoesMouseClicked

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        Tempo.stop();
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Tabela = (DefaultTableModel)Tabela_Conexoes.getModel();
        
        sql = "select * from tb_departamento where idEmpresa = " + parametrosNS.be.IdEmpresa + " and descricaoDepartamento = 'T.I';";
        PegaDepartamento();
        bu.codigoDepartamento = bd.codigoDepartamento;
        codigoDepartamento = bu.codigoDepartamento;
        
        consultouPrimeiraVez = "N";
        PegaUsuarios();
        consultouPrimeiraVez = "S";
        CarregarAutomaticamente();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabela_Conexoes;
    private javax.swing.JButton bt_encerrarConexao;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
    private void PegaUsuarios(){
        Tabela.setNumRows(0);
        sql    = "select \n" +
                 "   idUsuario, \n" +
                 "   idEmpresa, \n" +
                 "   codigoGrupo, \n" +
                 "   codigoEmpresa, \n" +
                 "   codigoUsuario, \n" +
                 "   nome, \n" +
                 "   usuario, \n" +
                 "   codigoDepartamento \n" +
                 "from \n" +
                 "   tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and \n" +
                 "       codigoDepartamento <> " + codigoDepartamento + " and nomeConexao <> 'null';";
        dadosUsuario.clear();
        dadosUsuario = parametrosNS.dao.Consulta(sql);
        if(dadosUsuario.isEmpty()){
            if(consultouPrimeiraVez.equals("S"))return;
            Mensagem = "Não existem Usuários conectados no Sistema!!!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosUsuarios();
    }
    
    private void PegaDadosUsuarios(){
        for(int i = 0; i < dadosUsuario.size(); i++){
            bu.idUsuario            = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(0)));
            bu.idEmpresa            = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(1)));
            bu.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(2)));
            bu.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(3)));
            bu.codigoUsuario        = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(4)));
            bu.nome                 =                    String.valueOf(dadosUsuario.get(i).get(5));
            bu.usuario              =                    String.valueOf(dadosUsuario.get(i).get(6));
            bu.codigoDepartamento   = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(7)));
            
            bd.codigoDepartamento  = bu.codigoDepartamento;
            sql = "select * from tb_departamento where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoDepartamento = " + bd.codigoDepartamento + ";";
            PegaDepartamento();
            
            Tabela.addRow(new Object[] {fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0) + "-" + bu.usuario, bu.nome, fc.FormataCampo(String.valueOf(bd.codigoDepartamento), 2, 0) + "-" + bd.descricaoDepartamento});
        }
    }
    
    private void PegaDepartamento(){
        bd.descricaoDepartamento = "----------";
        dadosDepartamentos.clear();
        dadosDepartamentos = parametrosNS.dao.Consulta(sql);
        if(dadosDepartamentos.isEmpty())
            return;
        PegaDadosDepartamento();
    }
    
    private void PegaDadosDepartamento(){
        for(int i = 0; i < dadosDepartamentos.size(); i++){
            bd = new BeanDepartamento();
            bd.idDepartamento           = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(0)));
            bd.idEmpresa                = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(1)));
            bd.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(2)));
            bd.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(3)));
            bd.codigoDepartamento       = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(4)));
            bd.descricaoDepartamento    =                    String.valueOf(dadosDepartamentos.get(i).get(5));
        }
    }
    
}
