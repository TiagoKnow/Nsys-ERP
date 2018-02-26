package FuncoesInternas;

import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/*
 author Tiago
 */
public class quebrarArquivo extends javax.swing.JFrame {
    Connection con;
    
    public quebrarArquivo(Connection con1) {
        initComponents();
        con = con1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txt_nomeDoArquivo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bt_buscarArquivo2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Retorno");

        jButton1.setText("Processar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Fechar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("R E T O R N O");

        bt_buscarArquivo2.setText("Buscar Arquivo");
        bt_buscarArquivo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscarArquivo2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txt_nomeDoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_buscarArquivo2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nomeDoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_buscarArquivo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String a= null;
        if(txt_nomeDoArquivo.getText().equals("") || txt_nomeDoArquivo.getText().equals(null)){
            JOptionPane.showMessageDialog(null, "Por favor, selecione um arquivo!");
        }else{
            processarArquivo("visulizar");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    void bt_buscarArquivo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscarArquivo2ActionPerformed

        //JFileChooser buscarDiretorio = new JFileChooser("C:\\Users\\Leonardo\\Desktop\\BOLETOS\\Arquivos Retorno\\Marco");
        JFileChooser buscarDiretorio = new JFileChooser("C:\\");

            buscarDiretorio.showOpenDialog(null);
            File arquivo = buscarDiretorio.getSelectedFile();

            txt_nomeDoArquivo.setText(arquivo.getAbsolutePath());
    }//GEN-LAST:event_bt_buscarArquivo2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_buscarArquivo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txt_nomeDoArquivo;
    // End of variables declaration//GEN-END:variables

   // void processarArquivo(String visulizar) {
        public void processarArquivo(String tipo){
        try{
                String nomeArq = txt_nomeDoArquivo.getText();
                String extenxaoArq = null;
                ArrayList dadosArquivo = new ArrayList();

                int t = 0;

                t = nomeArq.length()-3;

                extenxaoArq = nomeArq.substring(t);

                if(extenxaoArq.equals("ret") || extenxaoArq.equals("RET")){
                    dadosArquivo = dividirArquivoRetornoItau(nomeArq);
                    String var_cabecalho = null;//primeira posição do vetor
                    String var_rodape = null;//última posição do vetor
                    int tamanhoDoVetor = 0;
                    int var_arquivo = 1;
                    int var_parteInteira = 0;
                    int var_Resto = 0;
                    int x = 0; //variavel para controlar os registros
                    String nomeLoteArquivo = null;
                    
                    tamanhoDoVetor = dadosArquivo.size();
                    var_cabecalho = (String)dadosArquivo.get(0);
                    var_rodape = (String)dadosArquivo.get(tamanhoDoVetor -1);
                    
                    var_parteInteira = (tamanhoDoVetor -2) / 100;
                    var_Resto = (tamanhoDoVetor - 2) % 100;
                    
                    nomeLoteArquivo = JOptionPane.showInputDialog("Digige o nome do Lote: ");

                    //se o arquivo tiver menos do que 100 registros (excluindo cabeçalho e rodapé)
                    //não será preciso fazer nada
                    if(tamanhoDoVetor < 101){
                        JOptionPane.showMessageDialog(null, "Este arquivo não precisa ser dividido!");
                    }else{                     
                        
//========================= Fazer a parte inteira
                        for(int i = 0; i < var_parteInteira; i++){
                            
                            //adiciona o cabeçalho
                            ArrayList arquivo = new ArrayList();
                            arquivo.add(var_cabecalho);
                            
                            //adiciona os registros ao arquivo
                            for(int j = 0; j < 100; j++){
                                arquivo.add(dadosArquivo.get(x + 1));
                                x = x + 1;
                            }
                            
                            arquivo.add(var_rodape);
                            inserirLinha(arquivo, nomeLoteArquivo + " - " + var_arquivo);
                            var_arquivo = var_arquivo + 1;
                            arquivo = null;

                        }//fecha o for da parte inteira
                        
//======================== Fazer a parte restante ou seja o resto da divisão
                         if(var_Resto > 0){
                            ArrayList arquivo = new ArrayList();
                            arquivo.add(var_cabecalho);
                            
                            //adiciona os registros ao arquivo
                            for(int j = 0; j < var_Resto; j++){
                                arquivo.add(dadosArquivo.get(x + 1));
                                x = x + 1;
                            }
                            
                            arquivo.add(var_rodape);
                            inserirLinha(arquivo, nomeLoteArquivo + " - " + var_arquivo);
                            var_arquivo = var_arquivo + 1;
                            arquivo = null;
                         }
                        
                        JOptionPane.showMessageDialog(null, "Processo concluído com sucesso. \n "
                                + "Foram gerados: " + (var_arquivo - 1) + " arquivos!");
                        
                    }


                }else{
                    JOptionPane.showMessageDialog(null, "Selecione um Arquivo Válido! ");
                }
                    
        } catch (Exception er) {
            JOptionPane.showMessageDialog(null, "Erro ao processar o arquivo: " + er);
        }
    }    

    
//======================================= DIVIDIR ARQUIVO ==========================================    
    public boolean inserirLinha(ArrayList linhas, String nomeDoArquivo){
        //String nomeDoArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo:");
        
        File dir = new File("C:/sistema/Divididos");  
        boolean result = dir.mkdirs();  
        
        
        File novoArquivo = new File("C:\\sistema\\Divididos\\" + nomeDoArquivo + ".RET");
        try {
            boolean existe = novoArquivo.exists();

            if(existe == false){
                novoArquivo.createNewFile();
                FileWriter a = new FileWriter(novoArquivo,true);

                PrintWriter detalhes = new PrintWriter(a, true);

                for(int i = 0; i < linhas.size(); i++){
                    detalhes.println((String)(linhas.get(i)));
                }

                //JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso!");
            }
            if(existe == true){
                JOptionPane.showMessageDialog(null, "O arquivo já existe!");
            } 

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O ERRO FOI NO MÉTODO INSERIR LINHA: " + e);
        }
        return true;
    }//fecha o método    
    
    
//======================================= DIVIDIR ARQUIVO ==========================================
    public ArrayList dividirArquivoRetornoItau(String nomeDoArquivo){
        try{
          ArrayList dados = new ArrayList();
          FileReader leitor = new FileReader(nomeDoArquivo);//responsável por ler o arquivo
          BufferedReader ler = new BufferedReader(leitor);//responsável por ler o conteudo do arquivo
          String linha = null;

          int nLinha = 0;

          while((ler.ready())){ //Lê o arquivo linha a linha
                linha = ler.readLine();
                dados.add(linha);
                nLinha = nLinha + 1;
            }//fecha o while
           

            return dados;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "O erro foi no método dividirArquivoRetornoItau: " + e);
            return null;
        }
    }
}

