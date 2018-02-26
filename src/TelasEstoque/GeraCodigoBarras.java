package TelasEstoque;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BarcodeEAN;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Tiago
 */
public class GeraCodigoBarras extends javax.swing.JFrame {

    ArrayList dadosBarras  = new ArrayList();
    ArrayList listaCodigos = new ArrayList();
    
    String pastaSaida = "C://Saida//";
    
    String nomeProduto  = "";
    String codigoBarras = "";
    
    public GeraCodigoBarras(ArrayList dadosBarras1) {
        initComponents();
        dadosBarras = dadosBarras1;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        combo_codigos = new javax.swing.JComboBox();
        bt_adicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_codigos = new javax.swing.JTable();
        bt_gerar = new javax.swing.JButton();
        txt_codigoBarras = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_produto = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bt_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(":: Imprime código de barras");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setText("Padrão de código de barras");

        combo_codigos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EAN13", "EAN8", "UPCA", "UPCE" }));

        bt_adicionar.setText("Adicionar código");
        bt_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_adicionarActionPerformed(evt);
            }
        });

        tabela_codigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de barras"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela_codigos);

        bt_gerar.setText("Gerar Código");
        bt_gerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_gerarActionPerformed(evt);
            }
        });

        txt_codigoBarras.setEditable(false);
        txt_codigoBarras.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txt_codigoBarras.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setText("Código de Barras: ");

        jLabel3.setText("Produto: ");

        txt_produto.setEditable(false);

        jMenu1.setText("Arquivo");

        bt_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });
        jMenu1.add(bt_sair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_gerar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_codigos, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_adicionar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_codigoBarras)
                            .addComponent(txt_produto))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo_codigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_adicionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addComponent(bt_gerar)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(102, 102, 102)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_adicionarActionPerformed
        //Adiciona linhas na tabela
        if (combo_codigos.getSelectedItem().toString()== "EAN13" && txt_codigoBarras.getText().length() != 13) {
            JOptionPane.showMessageDialog(this, "Você deve digitar 13 números para este padrão de código de barras");
        } else {
            if (combo_codigos.getSelectedItem().toString()== "EAN8" && txt_codigoBarras.getText().length() != 8) {
                JOptionPane.showMessageDialog(this, "Você deve digitar 8 números para este padrão de código de barras");
            } else {
                DefaultTableModel modelo = (DefaultTableModel) tabela_codigos.getModel();
                int cont = 0;
                for (int i = 0; i < cont; i++) {
                    modelo.setNumRows(0);
                }

                //pega a quantidade de linhas e joga na variavel
                modelo.addRow(new Object[]{
                    this.txt_codigoBarras.getText()
                });
            }
        }
    }//GEN-LAST:event_bt_adicionarActionPerformed

    private void bt_gerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_gerarActionPerformed
        //        zerar a lista
        listaCodigos.clear();
        //adicionar os itens a lista
        for (int i = 0; i < tabela_codigos.getRowCount(); i++) {
            listaCodigos.add((String) tabela_codigos.getValueAt(i, 0));
        }
        //gerar o código
        gerarCodigoBarras();
    }//GEN-LAST:event_bt_gerarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //dadosBarras.clear();
        nomeProduto  = (String) dadosBarras.get(0);
        codigoBarras = (String) dadosBarras.get(1);
        
        txt_produto.setText(nomeProduto);
        txt_codigoBarras.setText(codigoBarras);
    }//GEN-LAST:event_formWindowOpened

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_adicionar;
    private javax.swing.JButton bt_gerar;
    private javax.swing.JMenuItem bt_sair;
    private javax.swing.JComboBox combo_codigos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_codigos;
    private javax.swing.JFormattedTextField txt_codigoBarras;
    private javax.swing.JTextField txt_produto;
    // End of variables declaration//GEN-END:variables

    public void gerarCodigoBarras() {

        System.out.println("Barcode Linha de Código ");

// criando um objeto da classe Document
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        try {

//Aqui começamos a utilizar as classes do iText: o documento
            //criado acima será
//direcionado para um arquivo PDF.
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pastaSaida + "barras.pdf"));

//abrindo o documento.
            document.open();
            
//adicionando um novo paragrafo.
            for (int i = 0; i < listaCodigos.size(); i++) {
                document.add(new Paragraph("CÓDIGOS DE BARRA"));

                document.add(new Paragraph("    "));

                document.add(new Paragraph("    "));

                //Comecando a configurar o cod de barras
                PdfContentByte cb = writer.getDirectContent();

                BarcodeEAN codeEAN = new BarcodeEAN();

                //O iText suporta os principais tipos de código de barra, como Barcode39,
//  Barcode128 (128, 128_UCC, 128_RAW),  BarcodeEAN (EAN13, EAN8, UPCA, UPCE), EANSUP, etc
                if (combo_codigos.getSelectedItem().toString() == "EAN13") {
                    codeEAN.setCodeType(codeEAN.EAN13);
                } else if ("EAN8".equals(combo_codigos.getSelectedItem().toString())) {
                    codeEAN.setCodeType(codeEAN.EAN8);
                } else if ("UPCA".equals(combo_codigos.getSelectedItem().toString())) {
                    codeEAN.setCodeType(codeEAN.UPCA);
                } else if ("UPCE".equals(combo_codigos.getSelectedItem().toString())) {
                    codeEAN.setCodeType(codeEAN.UPCE);
                }

                codeEAN.setCode("1234567890123");

                Image imageEAN = codeEAN.createImageWithBarcode(cb, null, null);

                document.add(new Phrase(new Chunk(imageEAN, 0, 0)));
            }
            //abrir o arquivo
            File file = new File(pastaSaida + "barras.pdf");
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception de) {
            de.printStackTrace();

        }
        document.close();

    }
}

