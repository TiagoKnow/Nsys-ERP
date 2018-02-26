package Telas;

import BeansNS.BeanBancoDados;
import BeansNS.BeanEmpresas;
import BeansNS.BeanGrupoEmpresa;
import BeansNS.BeanModulosAcesso;
import Beans.BeanParametros;
import Beans.BeanUsuarios;
import Beans.BeanModulos;
import Beans.BeanDepartamento;
import Beans.BeanUsuariosEmail;
import FuncoesInternas.*;
import Main.BarraInicial;
import Main.ProcessoInicial;
import Parametros.parametrosNS;
import java.sql.*;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
/*
 @author Tiago e Paulo
 */
public class UsuariosCadastro extends javax.swing.JFrame {
    //String's
    String sql                = "";
    String sqlstate           = "";
    String somostra           = "";
    String mensagem           = "";
    String fatal              = "N";
    String Tipo               = "";
    String dataAtual          = "";
    String horaAtual          = "";
    String operacao           = "I";
    String operacaoPerfil     = "I";
    String operacaoEmail      = "I";
    String dataHoje           = "";
    String retorno            = "";
    String PegaPerfilPadrao   = "N";
    String leuImagem          = "";
    String pastaImagemUsuario = "";
    String addEmp             = "";
    
    //ArrayList's
    ArrayList            parametros             = new ArrayList();
    ArrayList            dadosAbas              = new ArrayList();
    ArrayList            dadosPadroes           = new ArrayList();
    ArrayList            AbasSistema            = new ArrayList();
    ArrayList<ArrayList> dadosModulos           = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuarios          = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuariosEmail     = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosEmpresas          = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosParametros        = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosDepartamentos     = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUltimoRegistro    = new ArrayList<ArrayList>();
    
    //int's
    int    UltimoRegistro           = 0;
    int    abriuUsuario             = 0;
    int    length                   = 0;
    int    qtdColunas               = 0;
    int    qtdLinhas                = 0;
    int    linha                    = 0;
    int    coluna                   = 0;
    
    //beans
    BeanUsuarios            bu      = new BeanUsuarios();
    BeanUsuarios            bu1     = new BeanUsuarios();
    BeanUsuariosEmail       bue     = new BeanUsuariosEmail();
    BeanParametros          bp      = new BeanParametros();
    BeanDepartamento        bd      = new BeanDepartamento();
    BeanModulos             bm      = new BeanModulos();
    BeanGrupoEmpresa        bge     = new BeanGrupoEmpresa();
    BeanEmpresas            be      = new BeanEmpresas();
    BeanBancoDados          bbd     = new BeanBancoDados();
    BeanParametros          bpar    = new BeanParametros();
    BeanModulosAcesso       bma     = new BeanModulosAcesso();
    
    //Outros
    ValidarData             validaData      = new ValidarData();
    CapturarDataHora        cdh             = new CapturarDataHora();
    FileReader              pegarArquivo;
    BufferedReader          lerArquivo;
    File                    arquivoPasta    = null;
    JFileChooser            seletor         = new JFileChooser();
    FormataCPFCNPJ          FCpfCnpj        = new FormataCPFCNPJ();
    FormataCampo            fc              = new FormataCampo();
    DefaultTableModel       Table;
    PegaProximoRegistro     PegProReg       = new PegaProximoRegistro();
    
    //Especiais
    BufferedImage                   BuffImg;
    ByteArrayOutputStream           BytesImg;
    ImageIcon                       imgIcon;
    Image                           img;
    
    //Outros
    PreparedStatement       stmt;
    ResultSet               rs;
    JRResultSetDataSource   js;
    
    //Especiais para Relatórios
    String      JPV         = "";
    JasperPrint JPP         = null;
    HashMap     HM          = new HashMap();
    
    //Telas
    BarraInicial            Bar;
    DepartamentosCadastro   DepCad;
    ProcessoInicial         ProIni;
    UsuariosConsulta        ConUsu;
    
    public UsuariosCadastro(ArrayList DadosPadroes){
        dadosPadroes                = DadosPadroes;
        
        somostra                = (String)  dadosPadroes.get(0);
        Tipo                    = (String)  dadosPadroes.get(1);
        bu.codigoUsuario        = (int)     dadosPadroes.get(2);
        
        initComponents();
    }
    
    private void ConsultaParametros(){
        sql = "select * from tb_parametros where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametros.clear();
        dadosParametros = parametrosNS.dao.Consulta(sql);
        if(dadosParametros.isEmpty()){
            bt_imprimir.setEnabled(false);
            return;
        }
        PegaParametros();
    }
    
    private void PegaParametros(){
        for(int i = 0; i < dadosParametros.size(); i++){
            bpar.idParametros       = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(0)));
            bpar.idEmpresa          = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(1)));
            bpar.codigoGrupo        = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(2)));
            bpar.codigoEmpresa      = Integer.parseInt(  String.valueOf(dadosParametros.get(i).get(3)));
            bpar.pastaRelatorios    =                    String.valueOf(dadosParametros.get(i).get(4));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        label_alteracao = new javax.swing.JLabel();
        bt_pesquisar = new javax.swing.JButton();
        bt_confirma = new javax.swing.JButton();
        bt_anterior = new javax.swing.JButton();
        bt_proximo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label_imagem = new javax.swing.JLabel();
        bt_imagem = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_modulos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        combo_empresaAcesso = new javax.swing.JComboBox();
        txt_grupoAcesso = new javax.swing.JFormattedTextField();
        bt_imprimir = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        combo_nivelUsuario = new javax.swing.JComboBox();
        txt_usuario = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observacoes = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txt_datacriacao = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        bt_novo = new javax.swing.JButton();
        txt_telefone = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        check_mudarEmpresa = new javax.swing.JCheckBox();
        txt_nome = new javax.swing.JTextField();
        combo_departamento = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txt_senha = new javax.swing.JPasswordField();
        txt_codigoUsuario = new javax.swing.JFormattedTextField();
        combo_empresas = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        bt_sair1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastramento de Usuários");
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

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(361, 18));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        bt_pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/View.png"))); // NOI18N
        bt_pesquisar.setText("Pesquisa");
        bt_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarActionPerformed(evt);
            }
        });

        bt_confirma.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_confirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_confirma.setText("Confirma");
        bt_confirma.setEnabled(false);
        bt_confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmaActionPerformed(evt);
            }
        });

        bt_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Previous.png"))); // NOI18N
        bt_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_anteriorActionPerformed(evt);
            }
        });

        bt_proximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Next.png"))); // NOI18N
        bt_proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_proximoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_imagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_imagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        label_imagem.setPreferredSize(new java.awt.Dimension(3, 4));
        label_imagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_imagemMouseClicked(evt);
            }
        });

        bt_imagem.setText("Carregar Imagem");
        bt_imagem.setEnabled(false);
        bt_imagem.setFocusable(false);
        bt_imagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imagemActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Imagem de usuário");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(bt_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_imagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_imagem)
                .addContainerGap())
        );

        tabela_modulos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_modulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Módulos", "", "Consultas", "Arquivos", "Movimentos", "Relatórios", "Parâmetros", "Especiais"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_modulos.setAutoResizeMode(tabela_modulos.AUTO_RESIZE_OFF);
        tabela_modulos.setShowVerticalLines(false);
        tabela_modulos.getTableHeader().setReorderingAllowed(false);
        tabela_modulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_modulosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_modulos);
        if (tabela_modulos.getColumnModel().getColumnCount() > 0) {
            tabela_modulos.getColumnModel().getColumn(0).setResizable(false);
            tabela_modulos.getColumnModel().getColumn(0).setPreferredWidth(130);
            tabela_modulos.getColumnModel().getColumn(1).setResizable(false);
            tabela_modulos.getColumnModel().getColumn(1).setPreferredWidth(1);
            tabela_modulos.getColumnModel().getColumn(2).setResizable(false);
            tabela_modulos.getColumnModel().getColumn(2).setPreferredWidth(90);
            tabela_modulos.getColumnModel().getColumn(3).setResizable(false);
            tabela_modulos.getColumnModel().getColumn(3).setPreferredWidth(90);
            tabela_modulos.getColumnModel().getColumn(4).setResizable(false);
            tabela_modulos.getColumnModel().getColumn(4).setPreferredWidth(90);
            tabela_modulos.getColumnModel().getColumn(5).setResizable(false);
            tabela_modulos.getColumnModel().getColumn(5).setPreferredWidth(90);
            tabela_modulos.getColumnModel().getColumn(6).setResizable(false);
            tabela_modulos.getColumnModel().getColumn(6).setPreferredWidth(90);
            tabela_modulos.getColumnModel().getColumn(7).setResizable(false);
            tabela_modulos.getColumnModel().getColumn(7).setPreferredWidth(90);
        }

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Acesso a Empresa:");

        combo_empresaAcesso.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));
        combo_empresaAcesso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_empresaAcessoItemStateChanged(evt);
            }
        });
        combo_empresaAcesso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_empresaAcessoFocusLost(evt);
            }
        });
        combo_empresaAcesso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_empresaAcessoMouseClicked(evt);
            }
        });

        try {
            txt_grupoAcesso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_grupoAcesso.setEditable(false);
        txt_grupoAcesso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_grupoAcesso.setText("01");
        txt_grupoAcesso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_grupoAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_empresaAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(combo_empresaAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_grupoAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_empresaAcesso, jLabel4});

        jTabbedPane1.addTab("Acessos", jPanel2);

        bt_imprimir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Print.png"))); // NOI18N
        bt_imprimir.setText("Imprimir");
        bt_imprimir.setToolTipText("");
        bt_imprimir.setEnabled(false);
        bt_imprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_imprimirMouseEntered(evt);
            }
        });
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Informações do usuário");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        combo_nivelUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----------", "1 - Comum", "2 - Chefe", "3 - Gerente", "4 - Diretor", "9 - Mestre" }));
        combo_nivelUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_nivelUsuarioActionPerformed(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Senha: ");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Usuário: ");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Departamento: ");

        txt_observacoes.setColumns(20);
        txt_observacoes.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txt_observacoes.setLineWrap(true);
        txt_observacoes.setRows(5);
        jScrollPane1.setViewportView(txt_observacoes);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Observações:");

        try {
            txt_datacriacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_datacriacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txt_datacriacao.setText("  /  /    ");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Empresa Padrão:");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Criado em: ");

        bt_novo.setText("Novo");
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        try {
            txt_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## #########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        try {
            txt_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Telefone: ");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nome: ");

        check_mudarEmpresa.setText("Pode Mudar Empresa");
        check_mudarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_mudarEmpresaActionPerformed(evt);
            }
        });

        combo_departamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));
        combo_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_departamentoActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código: ");

        txt_senha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_senhaMouseEntered(evt);
            }
        });

        try {
            txt_codigoUsuario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigoUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoUsuario.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                txt_codigoUsuarioHierarchyChanged(evt);
            }
        });
        txt_codigoUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_codigoUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoUsuarioFocusLost(evt);
            }
        });
        txt_codigoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoUsuarioKeyPressed(evt);
            }
        });

        combo_empresas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_empresasItemStateChanged(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Nível:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_empresas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(combo_departamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_nivelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txt_nome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(check_mudarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txt_codigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_novo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_usuario)
                                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_datacriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)))))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel11, jLabel16, jLabel2, jLabel3, jLabel5});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_novo)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check_mudarEmpresa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_datacriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo_empresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combo_nivelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(combo_departamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 54, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, check_mudarEmpresa, combo_departamento, combo_nivelUsuario, jLabel1, jLabel11, jLabel12, jLabel13, jLabel16, jLabel17, jLabel2, jLabel3, jLabel5, txt_codigoUsuario, txt_nome, txt_senha, txt_telefone, txt_usuario});

        jMenu1.setText("Arquivo");

        jMenu2.setText("Cadastro");

        jMenuItem1.setText("Cadastro de Departamentos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenu1.add(jMenu2);
        jMenu1.add(jSeparator1);

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
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bt_confirma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_imprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_pesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_proximo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(bt_sair))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_anterior, bt_proximo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_proximo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_anterior, bt_confirma, bt_imprimir, bt_pesquisar, bt_proximo, bt_sair});

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        if(operacao.equals("I")){
            IncluirUsuario();
            if(fatal.equals("S"))return;
            VerificaPerfil();
            txt_codigoUsuario.grabFocus();
            return;
        }
        AlterarUsuario();
        if(fatal.equals("S"))return;
        VerificaPerfil();
        txt_codigoUsuario.grabFocus();
    }//GEN-LAST:event_bt_confirmaActionPerformed
    
    private void VerificaPerfil(){
        MontaModulos();
        MontaAbas();
        if(operacaoPerfil.equals("I")){
            IncluirPerfil();
            return;
        }
        AlterarPerfil();
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HabilitaCampos(false);
        
        txt_grupoAcesso.setText       (String.valueOf(parametrosNS.bge.codigoGrupo));
        txt_grupoAcesso.setText       (fc.FormataCampo(txt_grupoAcesso.getText(), 2, 0));
        txt_grupoAcesso.setToolTipText("Grupo: " + parametrosNS.bge.nomeGrupo);
        
        Table       = (DefaultTableModel)tabela_modulos.getModel();
        
        VerificaUltimoRegistro();
//        if(parametrosNS.bu.codigoUsuario != 999)
//            CarregarDepartamentos();
        bge.CodigoGrupo = parametrosNS.bge.CodigoGrupo;
        CarregarGruposEEmpresas("S");
        CarregarNomeModulos();
        ConsultaParametros();
        
        txt_codigoUsuario.grabFocus();
        
        if(somostra.equalsIgnoreCase("S")){
            bt_confirma     .setVisible(false);
            bt_pesquisar    .setVisible(false);
            bt_imagem       .setEnabled(false);
            bt_novo         .setEnabled(false);
            bt_anterior     .setVisible(false);
            bt_proximo      .setVisible(false);
        }
        if(bu.codigoUsuario != 0){
            txt_codigoUsuario.setEditable   (false);
            txt_codigoUsuario.setFocusable  (false);
            txt_codigoUsuario.setText(String.valueOf(bu.codigoUsuario));
            PegaUsuario();
            txt_nome.grabFocus();
        }
//        if(parametrosNS.bu.codigoUsuario == 999)
//            bt_pesquisar.setVisible(false);
    }//GEN-LAST:event_formWindowOpened
    
    private void txt_senhaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_senhaMouseEntered
        if(parametrosNS.bu.codigoUsuario == 999)
            txt_senha.setToolTipText(txt_senha.getText());
    }//GEN-LAST:event_txt_senhaMouseEntered

    private void combo_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_departamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_departamentoActionPerformed

    private void combo_nivelUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_nivelUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_nivelUsuarioActionPerformed

    private void bt_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_anteriorActionPerformed
        bu.codigoUsuario = Integer.parseInt(fc.FormataCampo(txt_codigoUsuario.getText(), 3, 0));
        if(bu.codigoUsuario == 1){
            mensagem = "Não existe registro anterior!!!";
            new MostraMensagem(mensagem);
            return;
        }
        if(bu.codigoUsuario == 0)
            bu.codigoUsuario = 2;
        if(bu.codigoUsuario < 999)
            bu.codigoUsuario = bu.codigoUsuario - 1;
        if(bu.codigoUsuario > UltimoRegistro){
            bu.codigoUsuario = UltimoRegistro;
            txt_codigoUsuario.setText("0");
            mensagem = "Não existe registro anterior!!!";
            new MostraMensagem(mensagem);
            return;
        }
        ReiniciaCampos();
        ReiniciaModulos();
        txt_codigoUsuario.setText(String.valueOf(bu.codigoUsuario));
        PegaUsuario();
    }//GEN-LAST:event_bt_anteriorActionPerformed

    private void bt_proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_proximoActionPerformed
        bu.codigoUsuario = Integer.parseInt(fc.FormataCampo(txt_codigoUsuario.getText(), 3, 0));
        if(bu.codigoUsuario < 999)
            bu.codigoUsuario = bu.codigoUsuario + 1;
        if(bu.codigoUsuario > UltimoRegistro){
            bu.codigoUsuario = UltimoRegistro;
            mensagem = "Esse é o último registro!!!";
            new MostraMensagem(mensagem);
            return;
        }
        ReiniciaCampos();
        ReiniciaModulos();
        txt_codigoUsuario.setText(String.valueOf(bu.codigoUsuario));
        PegaUsuario();
    }//GEN-LAST:event_bt_proximoActionPerformed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        operacao       = "I";
        operacaoPerfil = "I";
//        operacaoEmail  = "I";
        
        ReiniciaCampos();
        ReiniciaModulos();
        HabilitaCampos(true);
        
        VerificaUltimoRegistro();
        txt_codigoUsuario.setText("999");
        
        bt_confirma.setEnabled(true);
        txt_nome.grabFocus();
        
        label_alteracao.setText("");
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarActionPerformed
        abriuUsuario = 1;
        parametros.clear();
        parametros.add("S");
        ConUsu = new UsuariosConsulta(parametros);
        ConUsu.setVisible(true);
    }//GEN-LAST:event_bt_pesquisarActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
        if(abriuUsuario == 0)
            return;
        retorno = ConUsu.getRetorno();
        if(retorno.equals(""))
            return;
        txt_codigoUsuario.setText(retorno);
        abriuUsuario = 0;
        PegaUsuario();
    }//GEN-LAST:event_formWindowGainedFocus

    private void check_mudarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_mudarEmpresaActionPerformed
        
    }//GEN-LAST:event_check_mudarEmpresaActionPerformed

    private void label_imagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_imagemMouseClicked
        
    }//GEN-LAST:event_label_imagemMouseClicked

    private void combo_empresaAcessoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_empresaAcessoFocusLost
        
    }//GEN-LAST:event_combo_empresaAcessoFocusLost

    private void tabela_modulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_modulosMouseClicked
        coluna = tabela_modulos.getSelectedColumn();
        if(coluna != 1)
            return;
        qtdColunas = tabela_modulos.getColumnCount();
        linha  = tabela_modulos.getSelectedRow();
        for(int colunas = 2; colunas < qtdColunas; colunas++){
            if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha, coluna))) == false){
                tabela_modulos.setValueAt(false, linha, colunas);
            }else{
                tabela_modulos.setValueAt(true, linha, colunas);
            }
        }
    }//GEN-LAST:event_tabela_modulosMouseClicked

    private void combo_empresaAcessoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_empresaAcessoMouseClicked
        
    }//GEN-LAST:event_combo_empresaAcessoMouseClicked

    private void bt_imprimirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_imprimirMouseEntered
        if(bt_imprimir.isEnabled() == false){
            bt_imprimir.setToolTipText("");
            return;
        }
        //bu.codigoUsuario = Integer.parseInt(txt_codigo.getText());
        bt_imprimir.setToolTipText("Imprimir dados do Usuário " + bu.codigoUsuario);
    }//GEN-LAST:event_bt_imprimirMouseEntered

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        bu.codigoUsuario = Integer.parseInt(txt_codigoUsuario.getText());
        sql = "select * from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        try{
            stmt = parametrosNS.con.prepareStatement(sql);
            rs   = stmt.executeQuery();
            js = new JRResultSetDataSource(rs);
            
            HM.put("NOMEEMPRESA", parametrosNS.be.nomeEmpresa);
            HM.put("ENDERECOEMPRESA", parametrosNS.be.enderecoEmpresa + ", " + parametrosNS.be.numeroEmpresa);
            HM.put("CEPEMPRESA", parametrosNS.be.cepEmpresa);
            HM.put("CIDADEEMPRESA", parametrosNS.be.cidadeEmpresa + ", " + parametrosNS.be.ufEmpresa);
            HM.put("BAIRROEMPRESA", parametrosNS.be.bairroEmpresa);
            HM.put("LOGOTIPOEMPRESA", parametrosNS.bge.pastaImagemLogotipo + "/LOGOTIPO." + parametrosNS.bge.extensaoImagemLogotipo);
            HM.put("TELEFONEEMPRESA", parametrosNS.be.telefoneEmpresa);
            HM.put("CNPJEMPRESA", FCpfCnpj.FormataCPFCNPJ(parametrosNS.be.cnpjEmpresa));
            HM.put("IMAGEMUSUARIO", parametrosNS.be.pastaImagemUsuario + "/USUARIO_" + bu.codigoUsuario + "." + parametrosNS.be.extensaoImagemUsuario);
//            System.out.println(parametrosNS.be.pastaImagemUsuario + "/USUARIO_" + bu.codigoUsuario + "." + parametrosNS.be.extensaoImagemUsuario);
            
            JPV = bpar.pastaRelatorios + "/RelatorioUsuario.jasper";
            
            JPP = JasperFillManager.fillReport(JPV, HM, js);
            JasperViewer.viewReport(JPP, false);
        }catch(Exception erro){
            mensagem = "Erro ao imprimir: " + erro.getMessage();
            new MostraMensagem(mensagem);
        }
    }//GEN-LAST:event_bt_imprimirActionPerformed

    private void bt_imagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imagemActionPerformed
        if(operacao.equals(""))
            return;
        seletor = new JFileChooser("C:/"); 
        seletor.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = seletor.showOpenDialog(null);
        if(i == 1)
            return;
        arquivoPasta = seletor.getSelectedFile();
        if(arquivoPasta.getPath().equals(""))
            return;
        pastaImagemUsuario = arquivoPasta.getPath();
        CarregaImagem();
    }//GEN-LAST:event_bt_imagemActionPerformed

    private void combo_empresaAcessoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_empresaAcessoItemStateChanged
        if(addEmp.equals("N")){
            return;
        }
        bm.idEmpresa        = parametrosNS.be.IdEmpresa;
        bm.codigoGrupo      = parametrosNS.bge.CodigoGrupo;
        bm.codigoEmpresa    = combo_empresaAcesso.getSelectedIndex();
        
        PegaPerfilPadrao    = "N";
        PegaPerfil();
    }//GEN-LAST:event_combo_empresaAcessoItemStateChanged

    private void bt_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair1ActionPerformed
        Sair();
    }//GEN-LAST:event_bt_sair1ActionPerformed
    
    private void Sair(){
        dispose();
        if(!Tipo.equalsIgnoreCase("Login"))
            return;
        Bar     = new BarraInicial();
        ProIni  = new ProcessoInicial(Bar);
    }
    
    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        Sair();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void txt_codigoUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioFocusGained
        if(txt_codigoUsuario.getText().replace(" ", "").equals(""))
            return;
        if(txt_codigoUsuario.isEditable() == false)
            return;
        operacao = "";
        ReiniciaCampos();
        ReiniciaModulos();
        HabilitaCampos(false);
    }//GEN-LAST:event_txt_codigoUsuarioFocusGained

    private void txt_codigoUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioFocusLost
        if(txt_codigoUsuario.isEditable() == false)
            return;
        if(txt_codigoUsuario.getText().equals(""))
            return;
        PegaUsuario();
    }//GEN-LAST:event_txt_codigoUsuarioFocusLost

    private void txt_codigoUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_nome.grabFocus();
    }//GEN-LAST:event_txt_codigoUsuarioKeyPressed

    private void txt_codigoUsuarioHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_txt_codigoUsuarioHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoUsuarioHierarchyChanged

    private void combo_empresasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_empresasItemStateChanged
        if(combo_empresas.getSelectedIndex() == 0)
            return;
        bge.codigoGrupo     = Integer.parseInt(String.valueOf(combo_empresas.getSelectedItem()).substring(0, 2));
        bge.CodigoGrupo     = bge.codigoGrupo;
        txt_grupoAcesso.setText(parametrosNS.fc.FormataCampo(String.valueOf(bge.CodigoGrupo), 2, 0));
        be.CodigoGrupo      = bge.CodigoGrupo;
        CarregarGruposEEmpresas("SS");
        if(parametrosNS.bu.codigoUsuario == 999)
            be.CodigoEmpresa    = Integer.parseInt(String.valueOf(combo_empresas.getSelectedItem()).substring(6 + bge.nomeGrupo.length(), 9 + bge.nomeGrupo.length()));
        else
            be.CodigoEmpresa    = Integer.parseInt(String.valueOf(combo_empresas.getSelectedItem()).substring(3, 6));
        CarregarDepartamentos();
    }//GEN-LAST:event_combo_empresasItemStateChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(DepCad != null)
            if(DepCad.isVisible()){
                DepCad.setState(JFrame.NORMAL);
                return;
            }
        combo_empresas.setSelectedIndex(0);
        parametros.clear();
        parametros.add("N");
        parametros.add("");
        parametros.add(0);
        DepCad = new DepartamentosCadastro(parametros);
        DepCad.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    public void CarregaImagem(){
        imgIcon = null;
        imgIcon = new ImageIcon(pastaImagemUsuario);
        img     = imgIcon.getImage();
        img     = img.getScaledInstance(label_imagem.getWidth() - 3, label_imagem.getHeight() - 3, img.SCALE_DEFAULT);
        label_imagem.setIcon(new ImageIcon(img));
    }
    
    public void VerificaUltimoRegistro(){
        sql = "select count(*) from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosUltimoRegistro.clear();
        dadosUltimoRegistro = parametrosNS.dao.Consulta(sql);
        UltimoRegistro = Integer.parseInt(  String.valueOf(dadosUltimoRegistro.get(0).get(0)));
    }
    
    private void CarregarDepartamentos(){
        sql = "select * from tb_departamento where codigoGrupo = " + bge.codigoGrupo + " and codigoEmpresa = " + be.CodigoEmpresa + ";";
        if(parametrosNS.bu.codigoUsuario == 999)
            sql = "select * from tb_departamento where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
//        System.out.println(sql);
        dadosDepartamentos.clear();
        dadosDepartamentos = parametrosNS.dao.Consulta(sql);
        if(dadosDepartamentos.isEmpty()){
            mensagem = "Não existem departamentos cadastrados!";
            new MostraMensagem(mensagem);
            return;
        }
        PreencherDepartamentos();
    }
    
    private void PreencherDepartamentos(){
        combo_departamento.removeAllItems();
        combo_departamento.addItem("----------");
        for(int i = 0; i < dadosDepartamentos.size(); i++){
            bd = new BeanDepartamento();
            bd.idDepartamento           = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(0)));
            bd.idEmpresa                = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(1)));
            bd.codigoGrupo              = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(2)));
            bd.codigoEmpresa            = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(3)));
            bd.codigoDepartamento       = Integer.parseInt(  String.valueOf(dadosDepartamentos.get(i).get(4)));
            bd.descricaoDepartamento    =                    String.valueOf(dadosDepartamentos.get(i).get(5));
            
            combo_departamento.addItem(fc.FormataCampo(String.valueOf(bd.codigoDepartamento), 2, 0) + "-" + bd.descricaoDepartamento);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_anterior;
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton bt_imagem;
    private javax.swing.JButton bt_imprimir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_pesquisar;
    private javax.swing.JButton bt_proximo;
    private javax.swing.JButton bt_sair;
    private javax.swing.JMenuItem bt_sair1;
    private javax.swing.JCheckBox check_mudarEmpresa;
    private javax.swing.JComboBox combo_departamento;
    private javax.swing.JComboBox combo_empresaAcesso;
    private javax.swing.JComboBox<String> combo_empresas;
    private javax.swing.JComboBox combo_nivelUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label_alteracao;
    private javax.swing.JLabel label_imagem;
    private javax.swing.JTable tabela_modulos;
    private javax.swing.JFormattedTextField txt_codigoUsuario;
    private javax.swing.JFormattedTextField txt_datacriacao;
    private javax.swing.JFormattedTextField txt_grupoAcesso;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextArea txt_observacoes;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JFormattedTextField txt_telefone;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
    
    private void CarregarGruposEEmpresas(String Add){
        if(Add.equals("S") || Add.equals("SS"))
            sql = "select nsemp.idEmpresa, nsgru.codigoGrupo, nsgru.nomeGrupo, nsemp.codigoEmpresa, nsemp.nomeFantasia from ns_grupoempresa nsgru inner join ns_empresas nsemp on (nsgru.codigoGrupo = nsemp.codigoGrupo) where nsgru.codigoGrupo = " + bge.CodigoGrupo + ";";
        if(Add.equals("S"))
            if(parametrosNS.bu.codigoUsuario == 999)
                sql = "select nsemp.idEmpresa, nsgru.codigoGrupo, nsgru.nomeGrupo, nsemp.codigoEmpresa, nsemp.nomeFantasia from ns_grupoempresa nsgru inner join ns_empresas nsemp on (nsgru.codigoGrupo = nsemp.codigoGrupo);";
        if(Add.equals("N"))
            sql = "select nsemp.idEmpresa, nsgru.codigoGrupo, nsgru.nomeGrupo, nsemp.codigoEmpresa, nsemp.nomeFantasia from ns_grupoempresa nsgru inner join ns_empresas nsemp on (nsgru.codigoGrupo = nsemp.codigoGrupo) where nsgru.codigoGrupo = " + bge.CodigoGrupo + ";";
        if(Add.equals("SN"))
            sql = "select nsemp.idEmpresa, nsgru.codigoGrupo, nsgru.nomeGrupo, nsemp.codigoEmpresa, nsemp.nomeFantasia from ns_grupoempresa nsgru inner join ns_empresas nsemp on (nsgru.codigoGrupo = nsemp.codigoGrupo) where nsgru.codigoGrupo = " + bge.CodigoGrupo + " and nsemp.codigoEmpresa = " + be.codigoEmpresa + ";";
        dadosEmpresas.clear();
        dadosEmpresas = parametrosNS.dao.Consulta(sql);
        if(dadosEmpresas.isEmpty()){
            mensagem = "Não existe Empresas cadastradas para o Grupo " + parametrosNS.bge.CodigoGrupo + ".";
            new MostraMensagem(mensagem);
            return;
        }
        PrencherComboEmpresas(Add);
    }
    
    private void PrencherComboEmpresas(String Add){
        addEmp = "N";
        if(Add.equals("S") || Add.equals("SS")){
            if(Add.equals("S")){
                combo_empresas.removeAllItems();
                combo_empresas.addItem("----------");
            }
            combo_empresaAcesso.removeAllItems();
            combo_empresaAcesso.addItem("Todas as Empresas");
        }
        for(int i = 0; i < dadosEmpresas.size(); i++){
            be.idEmpresa        = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(0)));
            bge.CodigoGrupo     = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(1)));
            bge.nomeGrupo       =                    String.valueOf(dadosEmpresas.get(i).get(2));
            be.CodigoGrupo      = bge.CodigoGrupo;
            be.CodigoEmpresa    = Integer.parseInt(  String.valueOf(dadosEmpresas.get(i).get(3)));
            be.NomeFantasia     =                    String.valueOf(dadosEmpresas.get(i).get(4));
            
            if(Add.equals("S") || Add.equals("SS"))
                combo_empresaAcesso .addItem(fc.FormataCampo(String.valueOf(be.CodigoEmpresa), 3, 0) + " - " + be.NomeFantasia);
            
            if(Add.equals("S"))
                if(parametrosNS.bu.codigoUsuario != 999)
                    combo_empresas      .addItem(fc.FormataCampo(String.valueOf(bge.CodigoGrupo), 2, 0) + "." + fc.FormataCampo(String.valueOf(be.CodigoEmpresa), 3, 0) + " - " + be.NomeFantasia);
                else
                    combo_empresas      .addItem(fc.FormataCampo(String.valueOf(bge.CodigoGrupo), 2, 0) + "." + bge.nomeGrupo +  " - " + fc.FormataCampo(String.valueOf(be.CodigoEmpresa), 3, 0) + "." + be.NomeFantasia);
        }
        addEmp = "S";
    }
    
    private void PegaUsuario(){
        fatal = "N";
        txt_codigoUsuario.setText(fc.FormataCampo(txt_codigoUsuario.getText(), 3, 0));
        bu.codigoUsuario = Integer.parseInt(txt_codigoUsuario.getText());
        if(bu.codigoUsuario == 0)
            return;
        sql = "select * from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        dadosUsuarios.clear();
        dadosUsuarios = parametrosNS.dao.Consulta(sql);
        if(dadosUsuarios.isEmpty()){
            fatal = "S";
            bt_confirma.setEnabled(false);
            mensagem = "Codigo não encontrado, para incluir um novo registro pressione NOVO!!!";
            new MostraMensagem(mensagem);
            return;
        }
        operacao = "A";
        PegaDadosUsuario();
        HabilitaCampos(true);
        bt_confirma         .setEnabled(false);
        bt_imprimir         .setEnabled(false);
        PegaPerfilPadrao = "S";
        bm.idEmpresa        = bu.idEmpresa;
        bm.codigoGrupo      = bu.codigoGrupo;
        bm.codigoEmpresa    = bu.codigoEmpresa;
        bm.usuarioModulo    = bu.codigoUsuario;
        PegaPerfil();
    }
    
    private void PegaDadosUsuario(){
        for(int i =0; i < dadosUsuarios.size(); i++){
            bu = new BeanUsuarios();
            if(dadosUsuarios.get(i).get(0) != null)
                bu.idUsuario            = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(0)));
            if(dadosUsuarios.get(i).get(1) != null)
                bu.idEmpresa            = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(1)));
            if(dadosUsuarios.get(i).get(2) != null)
                bu.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(2)));
            if(dadosUsuarios.get(i).get(3) != null)
                bu.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(3)));
            if(dadosUsuarios.get(i).get(4) != null)
                bu.codigoUsuario        = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(4)));
            if(dadosUsuarios.get(i).get(5) != null)
                bu.dataCriacao          =                    String.valueOf(dadosUsuarios.get(i).get(5));
            if(dadosUsuarios.get(i).get(6) != null)
                bu.nome                 =                    String.valueOf(dadosUsuarios.get(i).get(6));
            if(dadosUsuarios.get(i).get(7) != null)
                bu.usuario              =                    String.valueOf(dadosUsuarios.get(i).get(7));
            if(dadosUsuarios.get(i).get(8) != null)
                bu.senha                =                    String.valueOf(dadosUsuarios.get(i).get(8));
            if(dadosUsuarios.get(i).get(9) != null)
                bu.telefone             =                    String.valueOf(dadosUsuarios.get(i).get(9));
            if(dadosUsuarios.get(i).get(10) != null)
                bu.codigoDepartamento   = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(10)));
            if(dadosUsuarios.get(i).get(11) != null)
                bu.nivelUsuario         = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(11)));
            if(dadosUsuarios.get(i).get(12) != null)
                bu.podeMudarEmpresa     = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(12)));
            if(dadosUsuarios.get(i).get(13) != null)
                bu.observacoes          =                    String.valueOf(dadosUsuarios.get(i).get(13));
            if(dadosUsuarios.get(i).get(14) != null)
                bu.nomeConexao          =                    String.valueOf(dadosUsuarios.get(i).get(14));
            if(dadosUsuarios.get(i).get(15) != null)
                bu.dataAlterou          =                    String.valueOf(dadosUsuarios.get(i).get(15));
            if(dadosUsuarios.get(i).get(16) != null)
                bu.horaAlterou          =                    String.valueOf(dadosUsuarios.get(i).get(16));
            if(dadosUsuarios.get(i).get(17) != null)
                bu.usuarioAlterou       = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(17)));
            if(dadosUsuarios.get(i).get(18) != null)
                bu.idEmpresaAlterou     = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(18)));
            if(dadosUsuarios.get(i).get(19) != null)
                bu.codigoGrupoAlterou   = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(19)));
            if(dadosUsuarios.get(i).get(20) != null)
                bu.codigoEmpresaAlterou = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(20)));
        }
        
//        bue.idUsuario   = bu.idUsuario;
//        PegaUsuarioEmail();
        
        bu.senha = parametrosNS.crpt.CriptografaManualmente(bu.senha);
        txt_codigoUsuario       .setText(fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0));
        bu.dataCriacao = parametrosNS.invdata.inverterData(bu.dataCriacao, 1);
        txt_datacriacao.setText(bu.dataCriacao);
        txt_nome                .setText(bu.nome);
        if(bu.podeMudarEmpresa != 0)check_mudarEmpresa.setSelected(true);
        txt_usuario             .setText(bu.usuario);
        txt_senha               .setText(bu.senha);
        txt_telefone.setText(bu.telefone);
        if(parametrosNS.bu.codigoUsuario != 999)
            combo_empresas.setSelectedIndex(bu.codigoEmpresa);
        else
            combo_empresas.setSelectedIndex(bu.idEmpresa);
        combo_departamento.setSelectedIndex(bu.codigoDepartamento);
        
        if(bu.nivelUsuario == 9)
            combo_nivelUsuario.setSelectedIndex(5);
        else
            combo_nivelUsuario.setSelectedIndex(bu.nivelUsuario);
        
        txt_observacoes.setText(bu.observacoes);
        
        if(bu.usuarioAlterou != 0){
            bu.usuario      = "NS3";
            bu.dataAlterou  = parametrosNS.invdata.inverterData(bu.dataAlterou, 1);
            if(parametrosNS.bu.codigoUsuario != 999){
                bu1.idEmpresa       = bu.idEmpresaAlterou;
                bu1.codigoGrupo     = bu.codigoGrupoAlterou;
                bu1.codigoEmpresa   = bu.codigoEmpresaAlterou;
                bu1.codigoUsuario   = bu.usuarioAlterou;
                PegaUsuarioAlterou();
            }
            label_alteracao.setText("Última alteração feita em " + bu.dataAlterou + " às " + bu.horaAlterou + " por " + bu1.usuario);
        }
        
        PegaImagemUsuario();
        if(bu.imagemUsuario == null)
            return;
        try{
            BuffImg = ImageIO.read(new ByteArrayInputStream(bu.imagemUsuario));
            imgIcon = new ImageIcon(BuffImg);
            img     = imgIcon.getImage();
            img     = img.getScaledInstance(label_imagem.getWidth() - 5, label_imagem.getHeight() - 5, img.SCALE_DEFAULT);
            
            label_imagem.setIcon(new ImageIcon(img));
        }catch(IOException e){
            
        }
    }
    
    private void PegaImagemUsuario(){
        sql = "select imagemUsuario from tb_usuarios where idUsuario = " + bu.idUsuario + ";";
        bu.imagemUsuario = parametrosNS.dao.ConsultaLogotipo(sql, "imagemUsuario");
    }
    
//    private void PegaUsuarioEmail(){
//        sql = "select * from tb_usuarios_email where idUsuario = " + bue.idUsuario + ";";
//        dadosUsuariosEmail.clear();
//        dadosUsuariosEmail = parametrosNS.dao.Consulta(sql);
//        if(dadosUsuariosEmail.isEmpty()){
//            mensagem = "Informações de email não encontradas para o usuário n°" + bu.codigoUsuario + ";";
//            new MostraMensagem(mensagem);
//            return;
//        }
//        operacaoEmail = "A";
//        PegaDadosUsuarioEmail();
//    }
//    
//    private void PegaDadosUsuarioEmail(){
//        for(int i = 0; i < dadosUsuariosEmail.size(); i++){
//            bue.idUsuarioEmail       = Integer.parseInt(  String.valueOf(dadosUsuariosEmail.get(i).get(0)));
//            bue.idUsuario            = Integer.parseInt(  String.valueOf(dadosUsuariosEmail.get(i).get(1)));
//        if(dadosUsuariosEmail.get(i).get(2) != null)
//            bue.servidorEmail        =                    String.valueOf(dadosUsuariosEmail.get(i).get(2));
//        if(dadosUsuariosEmail.get(i).get(3) != null)
//            bue.portaEmail           = Integer.parseInt(  String.valueOf(dadosUsuariosEmail.get(i).get(3)));
//        if(dadosUsuariosEmail.get(i).get(4) != null)
//            bue.usuarioServidorEmail =                    String.valueOf(dadosUsuariosEmail.get(i).get(4));
//        if(dadosUsuariosEmail.get(i).get(5) != null)
//            bue.senhaServidorEmail   =                    String.valueOf(dadosUsuariosEmail.get(i).get(5));
//        if(dadosUsuariosEmail.get(i).get(6) != null)
//            bue.email                =                    String.valueOf(dadosUsuariosEmail.get(i).get(6));
//        if(dadosUsuariosEmail.get(i).get(7) != null)
//            bue.autenticacaoSSL      = Integer.parseInt(  String.valueOf(dadosUsuariosEmail.get(i).get(7)));
//        }
//        txt_servidorEmail       .setText(bue.servidorEmail);
//        txt_portaEmail          .setText(fc.FormataCampo(String.valueOf(bue.portaEmail), 4, 0));
//        txt_usuarioServidorEmail.setText(bue.usuarioServidorEmail);
//        if(!bue.senhaServidorEmail.equals("null"))
//            txt_senhaServidorEmail  .setText(bue.senhaServidorEmail);
//        txt_email               .setText(bue.email);
//        if(bue.autenticacaoSSL == 1)check_SSL.setSelected(true);
//    }
    
    private void PegaUsuarioAlterou(){
        sql = "select usuario from tb_usuarios where codigoGrupo = " + bu1.codigoGrupo + " and codigoEmpresa = " + bu1.codigoEmpresa + " and codigoUsuario = " + bu1.codigoUsuario + ";";
        dadosUsuarios.clear();
        dadosUsuarios = parametrosNS.dao.Consulta(sql);
        if(dadosUsuarios.isEmpty()){
            mensagem = "Usuario " + bu1.codigoUsuario + " não encontrado!!!";
            new MostraMensagem(mensagem);
            bu.usuario = "";
            return;
        }
        PegaDadosUsuarioAlterou();
    }
    
    private void PegaDadosUsuarioAlterou(){
        for(int i = 0; i < dadosUsuarios.size(); i++)
            bu1.usuario = String.valueOf(dadosUsuarios.get(i).get(0));
    }
    
    private void PegaPerfil(){
        sql = "select * from tb_modulos where codigoGrupo = " + bm.codigoGrupo + " and codigoEmpresa = " + bm.codigoEmpresa + " and usuarioModulo = " + bm.usuarioModulo + ";";
        dadosModulos.clear();
        dadosModulos = parametrosNS.dao.Consulta(sql);
        ReiniciaModulos();
        if(dadosModulos.isEmpty()){
            if(PegaPerfilPadrao.equals("N")){
                operacaoPerfil = "I";
                bt_confirma.setEnabled(true);
                return;
            }
            PegaPerfilPadrao();
            return;
        }
        operacaoPerfil = "A";
        SetaModulos();
        bt_confirma.setEnabled(true);
        bt_imprimir.setEnabled(true);
    }
    
    private void PegaPerfilPadrao(){
        bm.codigoEmpresa = 0;
        sql = "select * from tb_modulos where codigoGrupo = " + bm.codigoGrupo + " and codigoEmpresa = " + bm.codigoEmpresa + " and usuarioModulo = " + bm.usuarioModulo + ";";
//        System.out.println(sql);
        dadosModulos.clear();
        dadosModulos = parametrosNS.dao.Consulta(sql);
        ReiniciaModulos();
        if(dadosModulos.isEmpty()){
            operacaoPerfil = "I";
            bt_confirma.setEnabled(true);
            return;
        }
        combo_empresaAcesso.setSelectedIndex(bm.codigoEmpresa);
        operacaoPerfil = "A";
        SetaModulos();
        bt_confirma.setEnabled(true);
        bt_imprimir.setEnabled(true);
    }
    
    private void SetaModulos(){
        qtdColunas  = tabela_modulos.getColumnCount();
        qtdLinhas   = tabela_modulos.getRowCount();
        linha       = 0;
        bm.idModulo = Integer.parseInt(  String.valueOf(dadosModulos.get(0).get(0)));
        bm.modulos  =                    String.valueOf(dadosModulos.get(0).get(5));
        if(parametrosNS.bma.moduloFaturamento        == 1){linha ++;if(bm.modulos.substring(0 , 1).equals("1"))tabela_modulos.setValueAt(true, linha - 1, 1);}
        if(parametrosNS.bma.moduloVendas             == 1){linha ++;if(bm.modulos.substring(1 , 2).equals("1"))tabela_modulos.setValueAt(true, linha - 1, 1);}
        if(parametrosNS.bma.moduloEstoque            == 1){linha ++;if(bm.modulos.substring(2 , 3).equals("1"))tabela_modulos.setValueAt(true, linha - 1, 1);}
        if(parametrosNS.bma.moduloContabil           == 1){linha ++;if(bm.modulos.substring(3 , 4).equals("1"))tabela_modulos.setValueAt(true, linha - 1, 1);}
        if(parametrosNS.bma.moduloFiscal             == 1){linha ++;if(bm.modulos.substring(4 , 5).equals("1"))tabela_modulos.setValueAt(true, linha - 1, 1);}
        if(parametrosNS.bma.moduloContasAReceber     == 1){linha ++;if(bm.modulos.substring(5 , 6).equals("1"))tabela_modulos.setValueAt(true, linha - 1, 1);}
        if(parametrosNS.bma.moduloContasAPagar       == 1){linha ++;if(bm.modulos.substring(6 , 7).equals("1"))tabela_modulos.setValueAt(true, linha - 1, 1);}
        if(parametrosNS.bma.moduloProducao           == 1){linha ++;if(bm.modulos.substring(7 , 8).equals("1"))tabela_modulos.setValueAt(true, linha - 1, 1);}
        if(parametrosNS.bma.moduloGestao             == 1){linha ++;if(bm.modulos.substring(8 , 9).equals("1"))tabela_modulos.setValueAt(true, linha - 1, 1);}
        if(parametrosNS.bma.moduloCompras            == 1){linha ++;if(bm.modulos.substring(9 ,10).equals("1"))tabela_modulos.setValueAt(true, linha - 1, 1);}
        if(parametrosNS.bma.moduloRecebimento        == 1){linha ++;if(bm.modulos.substring(10,11).equals("1"))tabela_modulos.setValueAt(true, linha - 1, 1);}
        if(parametrosNS.bma.moduloCRM                == 1){linha ++;if(bm.modulos.substring(11,12).equals("1"))tabela_modulos.setValueAt(true, linha - 1, 1);}
        if(parametrosNS.bma.moduloCC                 == 1){linha ++;if(bm.modulos.substring(12,13).equals("1"))tabela_modulos.setValueAt(true, linha - 1, 1);}
        if(parametrosNS.bma.moduloRH                 == 1){linha ++;if(bm.modulos.substring(13,14).equals("1"))tabela_modulos.setValueAt(true, linha - 1, 1);}
        
        SetaAbas();
    }
    
    private void SetaAbas(){
        AbasSistema.clear();
        bm.abasFaturamento    = String.valueOf(dadosModulos.get(0).get(6));
        bm.abasVendas         = String.valueOf(dadosModulos.get(0).get(7));
        bm.abasEstoque        = String.valueOf(dadosModulos.get(0).get(8));
        bm.abasContabil       = String.valueOf(dadosModulos.get(0).get(9));
        bm.abasFiscal         = String.valueOf(dadosModulos.get(0).get(10));
        bm.abasContasAReceber = String.valueOf(dadosModulos.get(0).get(11));
        bm.abasContasAPagar   = String.valueOf(dadosModulos.get(0).get(12));
        bm.abasProducao       = String.valueOf(dadosModulos.get(0).get(13));
        bm.abasGestao         = String.valueOf(dadosModulos.get(0).get(14));
        bm.abasCompras        = String.valueOf(dadosModulos.get(0).get(15));
        bm.abasRecebimento    = String.valueOf(dadosModulos.get(0).get(16));
        bm.abasCRM            = String.valueOf(dadosModulos.get(0).get(17));
        bm.abasCC             = String.valueOf(dadosModulos.get(0).get(18));
        bm.abasRH             = String.valueOf(dadosModulos.get(0).get(19));
        if(parametrosNS.bma.moduloFaturamento        == 1)AbasSistema.add(bm.abasFaturamento);
        if(parametrosNS.bma.moduloVendas             == 1)AbasSistema.add(bm.abasVendas);
        if(parametrosNS.bma.moduloEstoque            == 1)AbasSistema.add(bm.abasEstoque);
        if(parametrosNS.bma.moduloContabil           == 1)AbasSistema.add(bm.abasContabil);
        if(parametrosNS.bma.moduloFiscal             == 1)AbasSistema.add(bm.abasFiscal);
        if(parametrosNS.bma.moduloContasAReceber     == 1)AbasSistema.add(bm.abasContasAReceber);
        if(parametrosNS.bma.moduloContasAPagar       == 1)AbasSistema.add(bm.abasContasAPagar);
        if(parametrosNS.bma.moduloProducao           == 1)AbasSistema.add(bm.abasProducao);
        if(parametrosNS.bma.moduloGestao             == 1)AbasSistema.add(bm.abasGestao);
        if(parametrosNS.bma.moduloCompras            == 1)AbasSistema.add(bm.abasCompras);
        if(parametrosNS.bma.moduloRecebimento        == 1)AbasSistema.add(bm.abasRecebimento);
        if(parametrosNS.bma.moduloCRM                == 1)AbasSistema.add(bm.abasCRM);
        if(parametrosNS.bma.moduloCC                 == 1)AbasSistema.add(bm.abasCC);
        if(parametrosNS.bma.moduloRH                 == 1)AbasSistema.add(bm.abasRH);
        for(int linhas  = 0; linhas  < qtdLinhas;  linhas ++){
            for(int colunas = 2; colunas < qtdColunas; colunas++){
                if(String.valueOf(AbasSistema.get(linhas)).substring(colunas - 2, colunas - 1).equals("1")){
                    tabela_modulos.setValueAt(true, linhas, colunas);
                }else{
                    tabela_modulos.setValueAt(false, linhas, colunas);
                }
            }
        }
    }
    
    public void ReiniciaTela(){
        ReiniciaCampos();
        bt_confirma.setEnabled(false);
        bt_imprimir.setEnabled(false);
        txt_codigoUsuario.grabFocus();
    }
    
    public void ReiniciaCampos(){
        txt_codigoUsuario           .setText("");
        txt_nome                    .setText("");
        check_mudarEmpresa          .setSelected(false);
        txt_usuario                 .setText("");
        txt_senha                   .setText("");
        txt_telefone                .setText("");
        txt_datacriacao             .setText(cdh.CapturarData());
        if(combo_departamento.getItemCount() > 0)
            combo_departamento          .setSelectedIndex(0);
        combo_nivelUsuario          .setSelectedIndex(0);
        combo_empresas              .setSelectedIndex(0);
        txt_observacoes             .setText("");
        label_alteracao             .setText("");
        label_imagem                .setIcon(null);
//        txt_servidorEmail           .setText("");
//        txt_portaEmail              .setText(fc.FormataCampo("995", 4, 0));
//        txt_usuarioServidorEmail    .setText("");
//        txt_senhaServidorEmail      .setText("");
//        txt_email                   .setText("");
//        check_SSL                   .setSelected(true);
    }
    
    private void ReiniciaModulos(){
        qtdColunas = tabela_modulos.getColumnCount();
        qtdLinhas  = tabela_modulos.getRowCount();
        for(int colunas = 1; colunas < qtdColunas; colunas++){
            for(int linhas = 0; linhas < qtdLinhas; linhas++){
                tabela_modulos.setValueAt(false, linhas, colunas);
            }
        }
    }
    
    private void HabilitaCampos(boolean Habilita){
        txt_nome                    .setEditable    (Habilita);
        txt_nome                    .setFocusable   (Habilita);
        check_mudarEmpresa          .setEnabled     (Habilita);
        check_mudarEmpresa          .setFocusable   (Habilita);
        txt_usuario                 .setEditable    (Habilita);
        txt_usuario                 .setFocusable   (Habilita);
        txt_senha                   .setEditable    (Habilita);
        txt_senha                   .setFocusable   (Habilita);
        txt_telefone                .setEditable    (Habilita);
        txt_telefone                .setFocusable   (Habilita);
//        txt_email                   .setEditable    (Habilita);
//        txt_email                   .setFocusable   (Habilita);
        combo_departamento          .setEnabled     (Habilita);
        combo_departamento          .setFocusable   (Habilita);
        combo_nivelUsuario          .setEnabled     (Habilita);
        combo_nivelUsuario          .setFocusable   (Habilita);
        combo_empresas              .setEnabled     (Habilita);
        combo_empresas              .setFocusable   (Habilita);
        txt_observacoes             .setEditable    (Habilita);
        txt_observacoes             .setFocusable   (Habilita);
        bt_imagem                   .setEnabled     (Habilita);
        bt_imagem                   .setFocusable   (Habilita);
        combo_empresaAcesso         .setEnabled     (Habilita);
        combo_empresaAcesso         .setFocusable   (Habilita);
    }
    
    public void PegaValores(){
        fatal = "N";
        int codigoGrupo   = 0;
        int codigoEmpresa = 0;
        if(combo_empresas.getSelectedIndex() == 0){
            mensagem = "Empresa Padrão não selecionada!";
            new MostraMensagem(mensagem);
            fatal = "S";
            return;
        }
        bu.codigoGrupo      = Integer.parseInt(String.valueOf(combo_empresas.getSelectedItem()).substring(0, 2));
        bge.CodigoGrupo             = bu.codigoGrupo;
        CarregarGruposEEmpresas("N");
        if(parametrosNS.bu.codigoUsuario == 999)
            bu.codigoEmpresa            = Integer.parseInt(String.valueOf(combo_empresas.getSelectedItem()).substring(6 + bge.nomeGrupo.length(), 9 + bge.nomeGrupo.length()));
        else
            bu.codigoEmpresa            = Integer.parseInt(String.valueOf(combo_empresas.getSelectedItem()).substring(3, 6));
        be.codigoEmpresa            = bu.codigoEmpresa;
        CarregarGruposEEmpresas("SN");
        bu.idEmpresa                = be.idEmpresa;
        
        if(operacao.equals("I")){
            if(parametrosNS.bu.codigoUsuario != 999){
                codigoGrupo = parametrosNS.bge.codigoGrupo;
                parametrosNS.bge.codigoGrupo = bge.CodigoGrupo;
            }else{
                codigoGrupo = parametrosNS.bge.CodigoGrupo;
                parametrosNS.bge.CodigoGrupo = bge.CodigoGrupo;
            }
            codigoEmpresa = parametrosNS.be.CodigoEmpresa;
            parametrosNS.be.CodigoEmpresa = be.codigoEmpresa;
            bu.codigoUsuario            = PegProReg.PegaProximoRegistro("tb_usuarios", "codigoUsuario", "");
            if(parametrosNS.bu.codigoUsuario != 999)
                parametrosNS.bge.codigoGrupo = codigoGrupo;
            else
                parametrosNS.bge.CodigoGrupo = codigoGrupo;
            parametrosNS.be.CodigoEmpresa = codigoEmpresa;
        }else
            bu.codigoUsuario    = Integer.parseInt(txt_codigoUsuario.getText());
        
        bu.dataCriacao              = validaData.ValidaData(txt_datacriacao.getText());
        bu.nome                     = txt_nome.getText();
        bu.usuario                  = txt_usuario.getText();
        bu.senha                    = txt_senha.getText();
        bu.telefone                 = txt_telefone.getText();
        bu.telefone                 = bu.telefone.replace("(", "");
        bu.telefone                 = bu.telefone.replace(")", "");
        bu.telefone                 = bu.telefone.replace(" ", "");
        bu.telefone                 = bu.telefone.replace("-", "");
        if(!bu.telefone.equals(""))
            bu.telefone             = "'" + bu.telefone + "'";
        else
            bu.telefone             = null;
        bu.observacoes              = txt_observacoes.getText();
        
        if(bu.nome.equals("")){
            mensagem = "Nome inválido!!!";
            fatal = "S";
            new MostraMensagem(mensagem);
            txt_nome.grabFocus();
            return;
        }
        if(bu.usuario.equals("")){
            mensagem = "Usuário invalido!!!";
            fatal = "S";
            new MostraMensagem(mensagem);
            txt_usuario.grabFocus();
            return;
        }
        if(bu.senha.equals("")){
            mensagem = "Senha inválida!!!";
            fatal = "S";
            new MostraMensagem(mensagem);
            txt_senha.grabFocus();
            return;
        }
//        bu.senha = parametrosNS.crpt.CriptografaManualmente(bu.senha);
        if(combo_departamento.getSelectedIndex() == 0){
            mensagem = "Departamento inválido!!!";
            fatal = "S";
            new MostraMensagem(mensagem);
            combo_departamento.grabFocus();
            return;
        }
        bu.codigoDepartamento = Integer.parseInt(String.valueOf(combo_departamento.getSelectedItem()).substring(0, 2));
        if(combo_nivelUsuario.getSelectedIndex() == 0){
            mensagem = "Nivel de usuário inválido!!!";
            fatal = "S";
            new MostraMensagem(mensagem);
            combo_nivelUsuario.grabFocus();
            return;
        }
        bu.nivelUsuario = Integer.parseInt(String.valueOf(combo_nivelUsuario.getSelectedItem()).substring(0, 1));
        if(bu.dataCriacao.equals("N")){
            mensagem = "Data inválida!!!";
            fatal = "S";
            new MostraMensagem(mensagem);
            txt_datacriacao.grabFocus();
            return;
        }
        bu.dataCriacao = parametrosNS.invdata.inverterData(txt_datacriacao.getText(), 2);
        if(check_mudarEmpresa.isSelected() == false)
            bu.podeMudarEmpresa = 0;
        else
            bu.podeMudarEmpresa = 1;
        
        bu.idEmpresaAlterou     = parametrosNS.bu.idEmpresa;
        bu.codigoGrupoAlterou   = parametrosNS.bu.codigoGrupo;
        bu.codigoEmpresaAlterou = parametrosNS.bu.codigoEmpresa;
        bu.dataAlterou          = parametrosNS.invdata.inverterData(cdh.CapturarData(), 2);
        bu.horaAlterou          = cdh.CapturaHora();
        bu.usuarioAlterou       = parametrosNS.bu.codigoUsuario;
        
        try{
            BuffImg  = ImageIO.read(new File(pastaImagemUsuario));
            BytesImg = new ByteArrayOutputStream();
            
            ImageIO.write((BufferedImage)BuffImg, "jpg", BytesImg);
            BytesImg.flush();
            
            bu.imagemUsuario    = BytesImg.toByteArray();
            BytesImg.close();
            bu.setimagemUsuario(bu.imagemUsuario);
        }catch(Exception erro){
            
        }
    }
    
//    private void PegaValoresEmail(){
//        fatal = "N";
//        bue.servidorEmail            = txt_servidorEmail.getText();
//        if(bue.servidorEmail.equals("")){
//            mensagem = "Servidor de email inválido!";
//            new MostraMensagem(mensagem);
//            fatal = "S";
//            return;
//        }
//        bue.portaEmail               = Integer.parseInt(txt_portaEmail.getText().replace(" ", ""));
//        bue.usuarioServidorEmail     = txt_usuarioServidorEmail.getText();
//        if(bue.usuarioServidorEmail.equals("")){
//            mensagem = "Usuário do servidor de email inválido!";
//            new MostraMensagem(mensagem);
//            fatal = "S";
//            return;
//        }
//        bue.senhaServidorEmail       = txt_senhaServidorEmail.getText();
//        if(bue.senhaServidorEmail.equals("")){
//            mensagem = "Senha do servidor de email inválido!";
//            new MostraMensagem(mensagem);
//            fatal = "S";
//            return;
//        }
//        bue.senhaServidorEmail    = parametrosNS.crpt.CriptografaManualmente(bue.senhaServidorEmail);
//        bue.email                    = txt_email.getText();
//        if(bue.email.equals("")){
//            mensagem = "Email inválido!";
//            new MostraMensagem(mensagem);
//            fatal = "S";
//            return;
//        }
//        bue.autenticacaoSSL          = 0;
//        if(check_SSL.isSelected() == true)
//            bue.autenticacaoSSL      = 1;
//    }
    
    private void IncluirUsuario(){
        PegaValores();
        if(fatal.equals("S"))
            return;
        
        if(parametrosNS.bu.codigoUsuario == 999){
            parametrosNS.bge.CodigoGrupo  = bge.CodigoGrupo;
            parametrosNS.be.CodigoEmpresa = bu.codigoEmpresa;
            bu.codigoUsuario = PegProReg.PegaProximoRegistro("tb_usuarios", "codigoUsuario", "");
        }
        
        sql = "insert into tb_usuarios (idEmpresa, codigoGrupo, codigoEmpresa, codigoUsuario, dataCriacao, nome, usuario, senha, telefone, codigoDepartamento, nivelUsuario, podeMudarEmpresa, observacoes) "
            + "values (" + bu.idEmpresa + ", " + bu.codigoGrupo + ", " + bu.codigoEmpresa + ", " + bu.codigoUsuario + ", '" + bu.dataCriacao + "', '" + bu.nome + "', '" + bu.usuario + "', '" + bu.senha + "', " + bu.telefone + ", " + bu.codigoDepartamento + ", " + bu.nivelUsuario + ", " + bu.podeMudarEmpresa + ", '" + bu.observacoes + "');";
        
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir usuário!";
            new MostraMensagem(mensagem);
            return;
        }
        AtualizaImagens();
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir imagem do usuário!";
            new MostraMensagem(mensagem);
            return;
        }
        VerificaUltimoRegistro();
    }
    
    private void AlterarUsuario(){
        PegaValores();
        if(fatal.equals("S"))
            return;
        
        sql = "update tb_usuarios set idEmpresa = "             + bu.idEmpresa            + ", " +
                                     "codigoEmpresa = "         + bu.codigoEmpresa        + ", "  +
                                     "dataCriacao = '"          + bu.dataCriacao          + "', " +
                                     "nome = '"                 + bu.nome                 + "', " +
                                     "usuario = '"              + bu.usuario              + "', " +
                                     "senha = '"                + bu.senha                + "', " +
                                     "telefone = "              + bu.telefone             + ", " +
                                     "codigoDepartamento = "    + bu.codigoDepartamento   + ", " +
                                     "nivelUsuario = "          + bu.nivelUsuario         + ", " +
                                     "podeMudarEmpresa = "      + bu.podeMudarEmpresa     + ", " +
                                     "observacoes = '"          + bu.observacoes          + "', " +
                                     "idEmpresaAlterou = "      + bu.idEmpresaAlterou     + ", " +
                                     "codigoGrupoAlterou = "    + bu.codigoGrupoAlterou   + ", " +
                                     "codigoEmpresaAlterou = "  + bu.codigoEmpresaAlterou + ", " +
                                     "dataAlterou = '"          + bu.dataAlterou          + "', " +
                                     "horaAlterou = '"          + bu.horaAlterou          + "', " +
                                     "usuarioAlterou = "        + bu.usuarioAlterou       + " " + 
                                     "where idUsuario = "   + bu.idUsuario          + ";";
        
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao atualizar a imagem do usuário!";
            new MostraMensagem(mensagem);
            return;
        }
        AtualizaImagens();
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir imagem do usuário!";
            new MostraMensagem(mensagem);
            return;
        }
    }
    
    private void AtualizaImagens(){
        sql = "update tb_usuarios set imagemUsuario = ? where idEmpresa = " + bu.idEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
        sqlstate = parametrosNS.dao.atualizarImagens(sql, bu.getimagemUsuario());
    }
    
//    private void IncluirUsuarioEmail(){
//        PegaValoresEmail();
//        if(fatal.equals("S"))
//            return;
//        sql = "select idUsuario from tb_usuarios where idEmpresa = " + bu.idEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
//        dadosUsuarios = parametrosNS.dao.Consulta(sql);
//        bue.idUsuario = Integer.parseInt(String.valueOf(dadosUsuarios.get(0).get(0)));
//        
//        sql = "insert into tb_usuarios_email (idUsuario, servidorEmail, portaEmail, usuarioServidorEmail, senhaServidorEmail, email, autenticacaoSSL) "
//            + "values (" + bue.idUsuario + ", '" + bue.servidorEmail + "', '" + bue.portaEmail + "', '" + bue.usuarioServidorEmail + "', '" + bue.senhaServidorEmail + "', '" + bue.email + "', " + bue.autenticacaoSSL + ");";
//        sqlstate = parametrosNS.dao.incluirRegistro(sql);
//        if(!sqlstate.equals("00000")){
//            mensagem = "Não foi possível incluir as informações de email do usuário " + bu.codigoUsuario + "!";
//            new MostraMensagem(mensagem);
//            return;
//        }
//    }
    
//    private void AlterarUsuarioEmail(){
//        PegaValoresEmail();
//        if(fatal.equals("S"))
//            return;
//        sql = "update tb_usuarios_email set servidorEmail = '"         + bue.servidorEmail              + "', " +
//                                           "portaEmail = "            + bue.portaEmail                 + ", " +
//                                           "usuarioServidorEmail = '" + bue.usuarioServidorEmail       + "', " +
//                                           "senhaServidorEmail = '"   + bue.senhaServidorEmail         + "', " +
//                                           "email = '"                + bue.email                      + "', " +
//                                           "autenticacaoSSL = "       + bue.autenticacaoSSL            + " " +
//                                           "where idUsuario = " + bue.idUsuario + ";";
//        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
//        if(!sqlstate.equals("00000")){
//            mensagem = "Não foi possível atualizar as informações de email do usuário " + bu.codigoUsuario + "!";
//            new MostraMensagem(mensagem);
//            return;
//        }
//    }
    
    private void CarregarNomeModulos(){
        if(parametrosNS.bma.moduloFaturamento        == 1)Table.addRow(new Object [] {"Faturamento          "});
        if(parametrosNS.bma.moduloVendas             == 1)Table.addRow(new Object [] {"Vendas               "});
        if(parametrosNS.bma.moduloEstoque            == 1)Table.addRow(new Object [] {"Estoque              "});
        if(parametrosNS.bma.moduloContabil           == 1)Table.addRow(new Object [] {"Contábil             "});
        if(parametrosNS.bma.moduloFiscal             == 1)Table.addRow(new Object [] {"Fiscal               "});
        if(parametrosNS.bma.moduloContasAReceber     == 1)Table.addRow(new Object [] {"Contas à Receber     "});
        if(parametrosNS.bma.moduloContasAPagar       == 1)Table.addRow(new Object [] {"Contas à Pagar       "});
        if(parametrosNS.bma.moduloProducao           == 1)Table.addRow(new Object [] {"Produção             "});
        if(parametrosNS.bma.moduloGestao             == 1)Table.addRow(new Object [] {"Gestão Administrativa"});
        if(parametrosNS.bma.moduloCompras            == 1)Table.addRow(new Object [] {"Compras              "});
        if(parametrosNS.bma.moduloRecebimento        == 1)Table.addRow(new Object [] {"Recebimento          "});
        if(parametrosNS.bma.moduloCRM                == 1)Table.addRow(new Object [] {"CRM                  "});
        if(parametrosNS.bma.moduloCC                 == 1)Table.addRow(new Object [] {"ContasCorrentes      "});
        if(parametrosNS.bma.moduloRH                 == 1)Table.addRow(new Object [] {"Recursos Humanos     "});
    }
    
    private void MontaModulos(){
        String Modulo   = "0";
        dadosModulos.clear();
        linha           = 0;
        bm.modulos      = "";
        if(parametrosNS.bma.moduloFaturamento        == 1){linha++;if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha - 1, 1))) == true)Modulo = "1";}
        bm.modulos      = bm.modulos + Modulo;
        Modulo = "0";
        if(parametrosNS.bma.moduloVendas             == 1){linha++;if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha - 1, 1))) == true)Modulo = "1";}
        bm.modulos      = bm.modulos + Modulo;
        Modulo = "0";
        if(parametrosNS.bma.moduloEstoque            == 1){linha++;if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha - 1, 1))) == true)Modulo = "1";}
        bm.modulos      = bm.modulos + Modulo;
        Modulo = "0";
        if(parametrosNS.bma.moduloContabil           == 1){linha++;if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha - 1, 1))) == true)Modulo = "1";}
        bm.modulos      = bm.modulos + Modulo;
        Modulo = "0";
        if(parametrosNS.bma.moduloFiscal             == 1){linha++;if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha - 1, 1))) == true)Modulo = "1";}
        bm.modulos      = bm.modulos + Modulo;
        Modulo = "0";
        if(parametrosNS.bma.moduloContasAReceber     == 1){linha++;if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha - 1, 1))) == true)Modulo = "1";}
        bm.modulos      = bm.modulos + Modulo;
        Modulo = "0";
        if(parametrosNS.bma.moduloContasAPagar       == 1){linha++;if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha - 1, 1))) == true)Modulo = "1";}
        bm.modulos      = bm.modulos + Modulo;
        Modulo = "0";
        if(parametrosNS.bma.moduloProducao           == 1){linha++;if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha - 1, 1))) == true)Modulo = "1";}
        bm.modulos      = bm.modulos + Modulo;
        Modulo = "0";
        if(parametrosNS.bma.moduloGestao             == 1){linha++;if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha - 1, 1))) == true)Modulo = "1";}
        bm.modulos      = bm.modulos + Modulo;
        Modulo = "0";
        if(parametrosNS.bma.moduloCompras            == 1){linha++;if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha - 1, 1))) == true)Modulo = "1";}
        bm.modulos      = bm.modulos + Modulo;
        Modulo = "0";
        if(parametrosNS.bma.moduloRecebimento        == 1){linha++;if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha - 1, 1))) == true)Modulo = "1";}
        bm.modulos      = bm.modulos + Modulo;
        Modulo = "0";
        if(parametrosNS.bma.moduloCRM                == 1){linha++;if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha - 1, 1))) == true)Modulo = "1";}
        bm.modulos      = bm.modulos + Modulo;
        Modulo = "0";
        if(parametrosNS.bma.moduloCC                 == 1){linha++;if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha - 1, 1))) == true)Modulo = "1";}
        bm.modulos      = bm.modulos + Modulo;
        Modulo = "0";
        if(parametrosNS.bma.moduloRH                 == 1){linha++;if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha - 1, 1))) == true)Modulo = "1";}
        bm.modulos      = bm.modulos + Modulo;
        dadosAbas.add(bm.modulos);
    }
    
    private void MontaAbas(){
        qtdColunas  = tabela_modulos.getColumnCount();
        qtdLinhas   = tabela_modulos.getRowCount();
        linha       = 0;
        if(parametrosNS.bma.moduloFaturamento        == 1){FinalizaMontaAbas(1);}else{FinalizaMontaAbas(0);}
        if(parametrosNS.bma.moduloVendas             == 1){FinalizaMontaAbas(1);}else{FinalizaMontaAbas(0);}
        if(parametrosNS.bma.moduloEstoque            == 1){FinalizaMontaAbas(1);}else{FinalizaMontaAbas(0);}
        if(parametrosNS.bma.moduloContabil           == 1){FinalizaMontaAbas(1);}else{FinalizaMontaAbas(0);}
        if(parametrosNS.bma.moduloFiscal             == 1){FinalizaMontaAbas(1);}else{FinalizaMontaAbas(0);}
        if(parametrosNS.bma.moduloContasAReceber     == 1){FinalizaMontaAbas(1);}else{FinalizaMontaAbas(0);}
        if(parametrosNS.bma.moduloContasAPagar       == 1){FinalizaMontaAbas(1);}else{FinalizaMontaAbas(0);}
        if(parametrosNS.bma.moduloProducao           == 1){FinalizaMontaAbas(1);}else{FinalizaMontaAbas(0);}
        if(parametrosNS.bma.moduloGestao             == 1){FinalizaMontaAbas(1);}else{FinalizaMontaAbas(0);}
        if(parametrosNS.bma.moduloCompras            == 1){FinalizaMontaAbas(1);}else{FinalizaMontaAbas(0);}
        if(parametrosNS.bma.moduloRecebimento        == 1){FinalizaMontaAbas(1);}else{FinalizaMontaAbas(0);}
        if(parametrosNS.bma.moduloCRM                == 1){FinalizaMontaAbas(1);}else{FinalizaMontaAbas(0);}
        if(parametrosNS.bma.moduloCC                 == 1){FinalizaMontaAbas(1);}else{FinalizaMontaAbas(0);}
        if(parametrosNS.bma.moduloRH                 == 1){FinalizaMontaAbas(1);}else{FinalizaMontaAbas(0);}
        MontaPerfil();
    }
    
    private void FinalizaMontaAbas(int Modulo){
        String Abas = "000000";
        if(Modulo == 1){
            Abas = "";
            for(int colunas = 2; colunas < qtdColunas; colunas++){
                if(Boolean.valueOf(String.valueOf(tabela_modulos.getValueAt(linha, colunas))) == false)
                    Abas = Abas + "0";
                else
                    Abas = Abas + "1";
            }
            linha++;
        }
        dadosAbas.add(Abas);
    }
    
    private void MontaPerfil(){
        bm.idEmpresa            = be.idEmpresa;
        bm.codigoGrupo          = bge.codigoGrupo;
        if(parametrosNS.bu.codigoUsuario != 999)
            bm.codigoEmpresa    = combo_empresaAcesso.getSelectedIndex();
        else
            if(combo_empresaAcesso.getSelectedIndex() == 0)
                bm.codigoEmpresa    = 0;
            else
                bm.codigoEmpresa    = Integer.parseInt(String.valueOf(combo_empresaAcesso.getSelectedItem()).substring(0, 3));
        bm.usuarioModulo        = bu.codigoUsuario;
        bm.modulos              = (String) dadosAbas.get(0);
        bm.abasFaturamento      = (String) dadosAbas.get(1);
        bm.abasVendas           = (String) dadosAbas.get(2);
        bm.abasEstoque          = (String) dadosAbas.get(3);
        bm.abasContabil         = (String) dadosAbas.get(4);
        bm.abasFiscal           = (String) dadosAbas.get(5);
        bm.abasContasAReceber   = (String) dadosAbas.get(6);
        bm.abasContasAPagar     = (String) dadosAbas.get(7);
        bm.abasProducao         = (String) dadosAbas.get(8);
        bm.abasGestao           = (String) dadosAbas.get(9);
        bm.abasCompras          = (String) dadosAbas.get(10);
        bm.abasRecebimento      = (String) dadosAbas.get(11);
        bm.abasCRM              = (String) dadosAbas.get(12);
        bm.abasCC               = (String) dadosAbas.get(13);
        bm.abasRH               = (String) dadosAbas.get(14);
    }
    
    private void IncluirPerfil(){
        sql = "insert into tb_modulos (idEmpresa, codigoGrupo, codigoEmpresa, usuarioModulo, modulos, abasFaturamento, abasVendas, abasEstoque, abasContabil, abasFiscal, abasContasAReceber, abasContasAPagar, abasProducao, abasGestao, abasCompras, abasRecebimento, abasCRM, abasCC, abasRH) "
            + "values (" + bm.idEmpresa + ", " + bm.codigoGrupo + ", " + bm.codigoEmpresa + ", " + bm.usuarioModulo + ", '" + bm.modulos + "', '" + bm.abasFaturamento + "', '" + bm.abasVendas + "', '" + bm.abasEstoque + "', '" + bm.abasFiscal + "', '" + bm.abasContabil + "', '" + bm.abasContasAReceber + "', '" + bm.abasContasAPagar + "', '" + bm.abasProducao + "', '" + bm.abasGestao + "', '" + bm.abasCompras + "', '" + bm.abasRecebimento + "', '" + bm.abasCRM + "', '" + bm.abasCC + "', '" + bm.abasRH + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000"))
            return;
        mensagem = "Registro incluido com sucesso!";
        new MostraMensagem(mensagem);
        txt_codigoUsuario.grabFocus();
    }
    
    private void AlterarPerfil(){
        sql = "update tb_modulos set modulos = '"               + bm.modulos            + "', " +
                                    "abasFaturamento = '"       + bm.abasFaturamento    + "', " +
                                    "abasVendas = '"            + bm.abasVendas         + "', " +
                                    "abasEstoque = '"           + bm.abasEstoque        + "', " +
                                    "abasContabil = '"          + bm.abasContabil       + "', " +
                                    "abasFiscal = '"            + bm.abasFiscal         + "', " +
                                    "abasContasAReceber = '"    + bm.abasContasAReceber + "', " +
                                    "abasContasAPagar = '"      + bm.abasContasAPagar   + "', " +
                                    "abasProducao = '"          + bm.abasProducao       + "', " +
                                    "abasGestao = '"            + bm.abasGestao         + "', " +
                                    "abasCompras = '"           + bm.abasCompras        + "', " +
                                    "abasRecebimento = '"       + bm.abasRecebimento    + "', " +
                                    "abasCRM = '"               + bm.abasCRM            + "', " +
                                    "abasCC = '"                + bm.abasCC             + "', " +
                                    "abasRH = '"                + bm.abasRH             + "' "  +
                                    "where codigoGrupo = "  + bm.codigoGrupo        + " and " +
                                    "codigoEmpresa = "      + bm.codigoEmpresa      + " and " +
                                    "usuarioModulo = "      + bm.usuarioModulo      + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        
        if(!sqlstate.equals("00000"))
            return;
        mensagem = "Registro atualizado com sucesso!";
        new MostraMensagem(mensagem);
        txt_codigoUsuario.grabFocus();
    }
    
}
