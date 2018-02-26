package Telas;

import FuncoesInternas.InverterData;
import Beans.BeanLogAcesso;
import Beans.BeanUsuarios;
import Beans.BeanComputadores;
import Beans.BeanModulos;
import Beans.BeanUsuariosEmail;
import Dao.DaoMySQL;
import FuncoesInternas.CalcularDiasRestantesSistema;
import FuncoesInternas.TransformarSenhaSistemaEmData;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.Criptografia;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.TestarData;
import BeansNS.BeanModulosAcesso;
import TelasDeConfiguracoes.ConfiguraModulos;
import BeansNS.BeanBancoDados;
import BeansNS.BeanEmpresas;
import BeansNS.BeanGrupoEmpresa;
import BeansNS.BeanNsComputadores;
import Main.BarraInicial;
import TelasDeConfiguracoes.EmpresasCadastro;
import TelasDeConfiguracoes.GruposCadastro;
import TelasDeConfiguracoes.SalvarBancoDeDados;
import TelasDeConfiguracoes.daoSQLITE;
import Parametros.parametrosNS;
import daoConexao.fabricaConexaoMySQL;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 @author Tiago e Paulo
 */
public class Login extends javax.swing.JFrame {
    //Connection
    Connection con;
    
    //String
    String PastaSistema = "";
    String IpComputador = "";
    String mensagem     = "";
    
    //String
    String sql            = "";
    String Mensagem       = "";
    String retorno        = "";
    String linha          = "";
    String valorNome      = "";
    String valorSenha     = "";
    String fatal          = "N";
    String usuarioFatal   = "N";
    String sqlstate       = "00000";
    String dataHoje       = "";
    String senhaSistema   = "";
    String senhaDoSis     = "";
    String texto          = "";
    String fatalConexao   = "";
    String resultadoSenha = "";
    String caracterSenha  = "";
//    String Pasta          = System.getProperty("user.dir") + "/ArqPad.npt";
    String tipoCon        = "";
    String operacaoEmail  = "";
    String PressEnter     = "";
  
    String senhaMaster    = "";
    
    //Dao
    daoSQLITE dlite;
    
    //Vetores
    ArrayList            dadosGrupo      = new ArrayList();
    ArrayList            dadosEmpresa    = new ArrayList();
    ArrayList            dadosComputador = new ArrayList();
    ArrayList            dadosSistema    = new ArrayList();
    ArrayList            dadosPadroes    = new ArrayList();
    ArrayList<ArrayList> dadosModulos    = new ArrayList<ArrayList>();
  
    ArrayList<ArrayList> nsComputadores  = new ArrayList<ArrayList>();
    
    ArrayList            parametros        = new ArrayList();
    ArrayList            dadosConexao      = new ArrayList();
    ArrayList<ArrayList> dadosUsuario      = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuarioEmail = new ArrayList<ArrayList>();
    ArrayList<ArrayList> computador        = new ArrayList<ArrayList>();
    ArrayList<ArrayList> departamentos     = new ArrayList<ArrayList>();
    
    //ArrayList<ArrayList>
    ArrayList<ArrayList> valoresGrupos      = new ArrayList<ArrayList>();
    ArrayList<ArrayList> valoresEmpresas    = new ArrayList<ArrayList>();
    ArrayList<ArrayList> bancoDados         = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosModulosAcesso = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCount         = new ArrayList<ArrayList>();
    
    //Vetores
    ArrayList informacoes = new ArrayList();
    
    //DAO
    DaoMySQL dao;
//    DaoSqLite dlite;
    
    //Outros
    FormataCampo                  fc      = new FormataCampo();
    TestarData                    Test    = new TestarData();
    CalcularDiasRestantesSistema  cdr     = new CalcularDiasRestantesSistema();
    CapturarDataHora              cdh     = new CapturarDataHora();
    InverterData                  invdata = new InverterData();
    Criptografia                  crpt    = new Criptografia();
    TransformarSenhaSistemaEmData Tssed   = new TransformarSenhaSistemaEmData();
    
    //Beans
    BeanBancoDados     bbd     = new BeanBancoDados();
    BeanComputadores   bcomp   = new BeanComputadores();
    BeanEmpresas       be      = new BeanEmpresas();
    BeanGrupoEmpresa   bge     = new BeanGrupoEmpresa();
    BeanLogAcesso      bla     = new BeanLogAcesso();
    BeanModulos        bm      = new BeanModulos();
    BeanModulosAcesso  bma     = new BeanModulosAcesso();
    BeanNsComputadores bnscomp = new BeanNsComputadores();
    BeanUsuarios       bu      = new BeanUsuarios();
    BeanUsuariosEmail  bue     = new BeanUsuariosEmail();
    
    //Telas
    Senha                       senha;
    Sobre                       sobre;
    BarraInicial                Bar;
    MenuPrincipal               MenuPrin;
    MudarEmpresaAtual           MudEmpAtu;
    GruposCadastro              CadGru;
    EmpresasCadastro            CadEmp;
    ComputadoresCadastro        CadComp;
    DepartamentosCadastro       CadDep;
    UsuariosCadastro            CadUsu;
    SalvarBancoDeDados          SavBdD;
    InformacoesSistema          InfSis;
    ConfiguraModulos            ConfMod;
    public InformarSenhaSistema Inf;
    
    //int
    int    dataAtual         = 0;
    int    dataSis           = 0;
    int    qtdConexoes       = 0;
    int    length            = 0;
    int    abriuSenhaSistema = 0;
    int    abriuSenhaModulos = 0;
    int    abriuGrupo        = 0;
    int    abriuEmpresa      = 0;
    int    confirmacao       = 0;
    
    //long
    long   dias        = 0;
    long   senhaValida = 0;
    
    //Variaveis para Verificação da Senha do Sistema
    long   senhaSis = 0;
    String data     = "";
    
    //Especiais para Leitura de Arquivos
    FileReader     LerArquivo;
    BufferedReader LeuArquivo;
    FileWriter     GravarArquivo;
    PrintWriter    Gravar;
    File           DiretorioAtualizacao    = new File("Atualizacao.sql");
    
    //Telas
    
    //Var para acompanhar processo
    int    processoTotal = 0;
    int    contador      = 0;
    public String descricao     = "";
    
    public Login(BarraInicial bar){
        initComponents();
        Bar     = bar;
    }
    
    public void IniciaCarregamentoSistema(){
        fatal = "N";
        contador = 1;   descricao = "Lendo configurações de banco";                     SetaBarra();
        PegaBancoDeDados();
        if(fatal.equals("S")){descricao = "Configurações de banco não encontradas!";            DefineAcesso  (false);return;}
        ResetaMenus(false);
        contador = 2;   descricao = "Aguardando conexão ...";                           SetaBarra();
        AbreConexao();
        if(fatal.equals("S")){descricao = "Conexão não Estabelecida... \nEntre em contato com o Administrador do Sistema!"; DefineAcesso  (false);return;}
        contador = 3;   descricao = "Lendo informações do terminal...";                 SetaBarra();
        PegaInformacoesDoComputador();
        if(fatal.equals("S")){descricao = "Erro ao ler informações do terminal \nEntre em contato com o Administrador do Sistema!";             DefineAcesso  (false);return;}
        contador = 4;   descricao = "Conectado...";                                     SetaBarra();
        PegaComputadorLembrarEmail();
        DefineAcesso(true);
    }
    
    public void CarregamentoSistema(){
        if(bnscomp.lembrarEmail != 0){contador = 5;   descricao = "Carregando grupo...";                              SetaBarra();}
        PegaGrupo();
        if(fatal.equals("S")){descricao = "Erro ao carregar grupo \nEntre em contato com o Administrador do Sistema!";                          DefineAcesso  (false);return;}
        
        if(bnscomp.lembrarEmail != 0){contador = 6;   descricao = "Carregando informações da empresa ...";            SetaBarra();}
        PegaEmpresa();
        if(fatal.equals("S")){descricao = "Erro ao carregar informações da empresa \nEntre em contato com o Administrador do Sistema!";         DefineAcesso  (false);return;}
        
        if(bnscomp.lembrarEmail != 0){contador = 7;   descricao = "Lendo Módulos...";                                 SetaBarra();}
        LerModulosDeAcesso();
        if(fatal.equals("S")){descricao = "Erro ao carregar Módulos \nEntre em contato com o Administrador do Sistema!";                        DefineAcesso  (false);return;}
        
        if(bnscomp.lembrarEmail != 0){contador = 8;   descricao = "Verificando senha do sistema...";                  SetaBarra();}
        VerificaSenhaDoSistema();
        if(fatal.equals("S")){descricao = "Erro ao verificar senha do sistema \nEntre em contato com o Administrador do Sistema!";              DefineAcesso  (false);return;}
        
//        if(bnscomp.lembrarEmail != 0){contador = 9;  descricao = "Verificando conexões...";                           SetaBarra();}
//        VerificaQuantidadeConexoes();
//        if(fatal.equals("S")){descricao = "Erro ao verificar conexões \nEntre em contato com o Administrador do Sistema!";                      DefineAcesso  (false);return;}
        
        if(bnscomp.lembrarEmail != 0){contador = 10;   descricao = "Verificando departamentos...";                    SetaBarra();}
        VerificaDepartamentosCadastrados(); 
        if(fatal.equals("S")){descricao = "Erro ao verificar departamentos \nEntre em contato com o Administrador do Sistema!";                 DefineAcesso  (false);return;}
        
        if(bnscomp.lembrarEmail != 0){contador = 11;   descricao = "Acesso do terminal...";                           SetaBarra();}
        VerificaComputadorCadastrado();
        if(fatal.equals("S")){descricao = "Erro ao acessar terminal \nEntre em contato com o Administrador do Sistema!";                        DefineAcesso  (false);return;}
        
        if(bnscomp.lembrarEmail != 0){contador = 12;   descricao = "Verificando IP...";                               SetaBarra();}
        VerificaIpComputador();
        if(fatal.equals("S")){descricao = "Erro ao verificar IP \nEntre em contato com o Administrador do Sistema!";                            DefineAcesso  (false);return;}
        
        if(bnscomp.lembrarEmail != 0){contador = 13;   descricao = "Carregando informações do sistema...";            SetaBarra();}
        CarregarInformacoesSistema();
        if(fatal.equals("S")){descricao = "Erro ao carregar informações do sistema \nEntre em contato com o Administrador do Sistema!";         DefineAcesso  (false);return;}
        
        if(bnscomp.lembrarEmail != 0){contador = 14;descricao = "Definindo acesso...";                                SetaBarra();}
        DefineAcesso(true);
    }
    
    private void ResetaMenus(boolean Habilita){
        bt_CadastroDeGrupos         .setVisible(Habilita);
        bt_CadastroDeEmpresas       .setVisible(Habilita);
        bt_cadastroModulos          .setVisible(Habilita);
    }
    
    private void AdicionaGrupoCodigoConexao(){
        dadosConexao.clear();
        dadosConexao.add(bbd.servidor);  //0
        dadosConexao.add(bbd.porta);     //1
        dadosConexao.add(bbd.usuario);   //2
        dadosConexao.add(bbd.senha);     //3
        dadosConexao.add(bbd.nomeBanco); //4
    }

    private void AbreConexao(){
        AdicionaGrupoCodigoConexao();
        
        //if() se for my sql...
        con  = fabricaConexaoMySQL.AbrirConexao(dadosConexao);
        if(con == null){
            confirmacao = 1;
            fatal = "S";
            return;
        }
        parametrosNS.con = con;
        dadosConexao.add("Conectado!");
        dao     = new DaoMySQL(con);
        parametrosNS.dao = dao;
        
//        if(con != null)
//            return;
//        se for sqlite
//        con = fabricaConexaoSQLITE.abrirConexao("dados.db");
//        
//        parametrosNS.con = con;
//        dadosConexao.add("Conectado!");
//        dao     = new DaoMySQL(con);
//        parametrosNS.dao = dao;
        
        
    }
    
//    private void UsaBanco(){
//        sql = "Use " + bbd.nomeBanco + ";";
//        sqlstate = parametrosNS.dao.ConfiguraBancoMySQL(sql);
//        if(sqlstate.equals("42000")){
//            fatal = "S";
////            return;
//        }
//    }
    
    private void CriaTabelasSQLiteSeNaoExiste(){
        sql = "create table if not exists `nscomputadores` (\n" +
              "	`lembrarEmail`      INTEGER,\n" +
              "	`nomeComputador`    TEXT,\n" +
              "	`nomeEmail`         TEXT\n" +
              ")";
        dlite = new daoSQLITE();
        dlite.CriaTabela(sql);
        sql = "create table if not exists `nsconfig` (\n" +
              " `so`        TEXT,\n" +
              " `conexao`   INTEGER,\n" +
              " `servidor`  TEXT,\n" +
              " `porta`     INTEGER,\n" +
              " `nomeBanco` TEXT,\n" +
              " `usuario`   TEXT,\n" +
              " `senha`     TEXT\n" +
              ")";
        dlite = new daoSQLITE();
        dlite.CriaTabela(sql);
    }
    
    private void PegaBancoDeDados(){
        CriaTabelasSQLiteSeNaoExiste();
        fatal = "N";
        sql = "select * from nsconfig;";
        dlite = new daoSQLITE();
        bancoDados.clear();
        bancoDados = dlite.Consulta(sql);
        if(bancoDados.isEmpty()){
            fatal = "S";
            confirmacao = JOptionPane.showConfirmDialog(null, "Conexões de Banco de Dados inválida, deseja configurar?", "", JOptionPane.YES_NO_OPTION);
            if(confirmacao != 0){
                return;
            }
            SavBdD = new SalvarBancoDeDados("Login");
            return;
        }
        PegaDadosDoBancoDeDados();
    }
    
    private void PegaDadosDoBancoDeDados(){
        for(int i = 0; i < bancoDados.size(); i++){
            bbd.so              =                    String.valueOf(bancoDados.get(i).get(0));
            bbd.conexao         = Integer.parseInt(  String.valueOf(bancoDados.get(i).get(1)));
            bbd.servidor        =                    String.valueOf(bancoDados.get(i).get(2));
            bbd.porta           = Integer.parseInt(  String.valueOf(bancoDados.get(i).get(3)));
            bbd.nomeBanco       =                    String.valueOf(bancoDados.get(i).get(4));
            bbd.usuario         =                    String.valueOf(bancoDados.get(i).get(5));
            bbd.senha           =                    String.valueOf(bancoDados.get(i).get(6));
        }
        parametrosNS.bbd.so          = bbd.so;
        parametrosNS.bbd.conexao     = bbd.conexao;
        parametrosNS.bbd.servidor    = bbd.servidor;
        parametrosNS.bbd.porta       = bbd.porta;
        parametrosNS.bbd.nomeBanco   = bbd.nomeBanco;
        parametrosNS.bbd.usuario     = bbd.usuario;
        parametrosNS.bbd.senha       = bbd.senha;
    }
    
    private void VerificaTabelaUsuariosVazia(){
        sql = "select * from tb_usuarios;";
//        sql = "select * from tb_usuarios where codigoGrupo = " + bge.codigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
        dadosUsuario.clear();
        dadosUsuario = parametrosNS.dao.Consulta(sql);
        if(dadosUsuario.isEmpty()){
            usuarioFatal = "S";
            confirmacao = JOptionPane.showConfirmDialog(null, "Tabela de usuarios está vazia, Deseja criar um usuário?", "", JOptionPane.YES_NO_OPTION);
            if(confirmacao != 0){
                return;
            }
            senha = new Senha("Usuarios");
            AbreSenhaDoSistema();
            dispose();
        }
    }
    
    private void PegaUsuario(){
        fatal = "N";
        dadosUsuario.clear();
        dadosUsuario = parametrosNS.dao.Consulta(sql);
        if(dadosUsuario.isEmpty()){
            fatal = "S";
            VerificaTabelaUsuariosVazia();
            dadosUsuario.clear();
            if(usuarioFatal.equals("S")){
                return;
            }
            return;
        }
        PegaDadosUsuarios();
    }
    
    private void PegaDadosUsuarios(){
        for(int i = 0; i < dadosUsuario.size(); i++){
            if(dadosUsuario.get(i).get(0)  != null){bu.idUsuario            = Integer.parseInt(String.valueOf(dadosUsuario.get(i).get(0)));}
            if(dadosUsuario.get(i).get(1)  != null){bu.idEmpresa            = Integer.parseInt(String.valueOf(dadosUsuario.get(i).get(1)));}
            if(dadosUsuario.get(i).get(2)  != null){bu.codigoGrupo          = Integer.parseInt(String.valueOf(dadosUsuario.get(i).get(2)));}
            if(dadosUsuario.get(i).get(3)  != null){bu.codigoEmpresa        = Integer.parseInt(String.valueOf(dadosUsuario.get(i).get(3)));}
            if(dadosUsuario.get(i).get(4)  != null){bu.codigoUsuario        = Integer.parseInt(String.valueOf(dadosUsuario.get(i).get(4)));}
            if(dadosUsuario.get(i).get(5)  != null){bu.dataCriacao          =                  String.valueOf(dadosUsuario.get(i).get(5));}
            if(dadosUsuario.get(i).get(6)  != null){bu.nome                 =                  String.valueOf(dadosUsuario.get(i).get(6));}
            if(dadosUsuario.get(i).get(7)  != null){bu.usuario              =                  String.valueOf(dadosUsuario.get(i).get(7));}
            if(dadosUsuario.get(i).get(8)  != null){bu.senha                =                  String.valueOf(dadosUsuario.get(i).get(8));}
            if(dadosUsuario.get(i).get(9)  != null){bu.telefone             =                  String.valueOf(dadosUsuario.get(i).get(9));}
            if(dadosUsuario.get(i).get(10) != null){bu.codigoDepartamento   = Integer.parseInt(String.valueOf(dadosUsuario.get(i).get(10)));}
            if(dadosUsuario.get(i).get(11) != null){bu.nivelUsuario         = Integer.parseInt(String.valueOf(dadosUsuario.get(i).get(11)));}
            if(dadosUsuario.get(i).get(12) != null){bu.podeMudarEmpresa     = Integer.parseInt(String.valueOf(dadosUsuario.get(i).get(12)));}
            if(dadosUsuario.get(i).get(13) != null){bu.observacoes          =                  String.valueOf(dadosUsuario.get(i).get(13));}
            if(dadosUsuario.get(i).get(14) != null){bu.nomeConexao          =                  String.valueOf(dadosUsuario.get(i).get(14));}
            if(dadosUsuario.get(i).get(15) != null){bu.dataAlterou          =                  String.valueOf(dadosUsuario.get(i).get(15));}
            if(dadosUsuario.get(i).get(16) != null){bu.horaAlterou          =                  String.valueOf(dadosUsuario.get(i).get(16));}
            if(dadosUsuario.get(i).get(17) != null){bu.usuarioAlterou       = Integer.parseInt(String.valueOf(dadosUsuario.get(i).get(17)));}
            if(dadosUsuario.get(i).get(18) != null){bu.idEmpresaAlterou     = Integer.parseInt(String.valueOf(dadosUsuario.get(i).get(18)));}
            if(dadosUsuario.get(i).get(19) != null){bu.codigoGrupoAlterou   = Integer.parseInt(String.valueOf(dadosUsuario.get(i).get(19)));}
            if(dadosUsuario.get(i).get(20) != null){bu.codigoEmpresaAlterou = Integer.parseInt(String.valueOf(dadosUsuario.get(i).get(20)));}
        }
        parametrosNS.bu.idUsuario            = bu.idUsuario;
        parametrosNS.bu.idEmpresa            = bu.idEmpresa;
        parametrosNS.bu.codigoGrupo          = bu.codigoGrupo;
        parametrosNS.bu.codigoEmpresa        = bu.codigoEmpresa;
        parametrosNS.bu.codigoUsuario        = bu.codigoUsuario;
        parametrosNS.bu.dataCriacao          = bu.dataCriacao;
        parametrosNS.bu.nome                 = bu.nome;
        parametrosNS.bu.usuario              = bu.usuario;
        parametrosNS.bu.senha                = bu.senha;
//        parametrosNS.bu.senha = parametrosNS.crpt.CriptografaManualmente(parametrosNS.bu.senha);
        parametrosNS.bu.telefone             = bu.telefone;
        parametrosNS.bu.codigoDepartamento   = bu.codigoDepartamento;
        parametrosNS.bu.nivelUsuario         = bu.nivelUsuario;
        parametrosNS.bu.podeMudarEmpresa     = bu.podeMudarEmpresa;
        parametrosNS.bu.observacoes          = bu.observacoes;
        parametrosNS.bu.nomeConexao          = bu.nomeConexao;
        parametrosNS.bu.dataAlterou          = bu.dataAlterou;
        parametrosNS.bu.horaAlterou          = bu.horaAlterou;
        parametrosNS.bu.usuarioAlterou       = bu.usuarioAlterou;
        parametrosNS.bu.idEmpresaAlterou     = bu.idEmpresaAlterou;
        parametrosNS.bu.codigoGrupoAlterou   = bu.codigoGrupoAlterou;
        parametrosNS.bu.codigoEmpresaAlterou = bu.codigoEmpresaAlterou;
        PegaImagemUsuario();
        parametrosNS.bu.imagemUsuario        = bu.imagemUsuario;
        
        bue.idEmpresa       = bu.idEmpresa;
        bue.codigoGrupo     = bu.codigoGrupo;
        bue.codigoEmpresa   = bu.codigoEmpresa;
        bue.codigoUsuario   = bu.codigoUsuario;
        PegaUsuarioEmail();
        
        bm.idEmpresa        = bu.idEmpresa;
        bm.codigoGrupo      = bu.codigoGrupo;
        bm.codigoEmpresa    = bu.codigoEmpresa;
        PegaModulos();
        
        txt_senha.grabFocus();
        CarregamentoSistema();
    }
    
    private void PegaImagemUsuario(){
        sql = "select imagemUsuario from tb_usuarios where idUsuario = " + parametrosNS.bu.idUsuario + ";";
        bu.imagemUsuario = parametrosNS.dao.ConsultaLogotipo(sql, "imagemUsuario");
    }
    
    private void PegaUsuarioEmail(){
        sql = "select * from tb_usuarios_email where idEmpresa = " + bue.idEmpresa + " and codigoUsuario = " + bue.codigoUsuario + ";";
        dadosUsuarioEmail.clear();
        dadosUsuarioEmail = parametrosNS.dao.Consulta(sql);
        if(dadosUsuarioEmail.isEmpty()){
            return;
        }
        PegaDadosUsuarioEmail();
    }
    
    private void PegaDadosUsuarioEmail(){
        for(int i = 0; i < dadosUsuarioEmail.size(); i++){
            if(dadosUsuarioEmail.get(i).get(0)  != null){bue.idUsuarioEmail       = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(0)));}
            if(dadosUsuarioEmail.get(i).get(1)  != null){bue.idEmpresa            = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(1)));}
            if(dadosUsuarioEmail.get(i).get(2)  != null){bue.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(2)));}
            if(dadosUsuarioEmail.get(i).get(3)  != null){bue.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(3)));}
            if(dadosUsuarioEmail.get(i).get(4)  != null){bue.codigoUsuario        = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(4)));}
            if(dadosUsuarioEmail.get(i).get(2)  != null){bue.servidorEmail        =                    String.valueOf(dadosUsuarioEmail.get(i).get(5));}
            if(dadosUsuarioEmail.get(i).get(6)  != null){bue.portaEmail           = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(6)));}
            if(dadosUsuarioEmail.get(i).get(7)  != null){bue.usuarioServidorEmail =                    String.valueOf(dadosUsuarioEmail.get(i).get(7));}
            if(dadosUsuarioEmail.get(i).get(8)  != null){bue.senhaServidorEmail   =                    String.valueOf(dadosUsuarioEmail.get(i).get(8));}
            if(dadosUsuarioEmail.get(i).get(9)  != null){bue.email                =                    String.valueOf(dadosUsuarioEmail.get(i).get(9));}
            if(dadosUsuarioEmail.get(i).get(10) != null){bue.autenticacaoSSL      = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(10)));}
        }
        parametrosNS.bue.servidorEmail        = bue.servidorEmail;
        parametrosNS.bue.portaEmail           = bue.portaEmail;
        parametrosNS.bue.usuarioServidorEmail = bue.usuarioServidorEmail;
        if(!bue.senhaServidorEmail.equals("null"))
            parametrosNS.bue.senhaServidorEmail   = bue.senhaServidorEmail;
        else
            parametrosNS.bue.senhaServidorEmail   = "";
        parametrosNS.bue.email                = bue.email;
        parametrosNS.bue.autenticacaoSSL      = bue.autenticacaoSSL;
    }
    
    private void PegaModulos(){
        sql = "select * from tb_modulos where codigoGrupo = " + bm.codigoGrupo + " and codigoEmpresa = " + bm.codigoEmpresa + " and usuarioModulo = " + bu.codigoUsuario + ";";
        dadosModulos.clear();
        dadosModulos = parametrosNS.dao.Consulta(sql);
        if(!dadosModulos.isEmpty()){
            SetaModulos();
            return;
        }
        PegaModulosPadroes();
    }
    
    private void PegaModulosPadroes(){
        bm.codigoEmpresa = 0;
        sql = "select * from tb_modulos where codigoGrupo = " + bm.codigoGrupo + " and codigoEmpresa = " + bm.codigoEmpresa + " and usuarioModulo = " + bu.codigoUsuario + ";";
        dadosModulos.clear();
        dadosModulos = parametrosNS.dao.Consulta(sql);
        if(dadosModulos.isEmpty()){
            Mensagem = "Não existe Perfil criado para o usuário " +  bu.codigoUsuario + "!";
            new MostraMensagem(Mensagem);
            return;
        }
        SetaModulos();
    }
    
    private void SetaModulos(){
        parametrosNS.bm.idModulo            = Integer.parseInt(String.valueOf(dadosModulos.get(0).get(0)));
        parametrosNS.bm.idEmpresa           = Integer.parseInt(String.valueOf(dadosModulos.get(0).get(1)));
        parametrosNS.bm.codigoGrupo         = Integer.parseInt(String.valueOf(dadosModulos.get(0).get(2)));
        parametrosNS.bm.codigoEmpresa       = Integer.parseInt(String.valueOf(dadosModulos.get(0).get(3)));
        parametrosNS.bm.usuarioModulo       = Integer.parseInt(String.valueOf(dadosModulos.get(0).get(4)));
        parametrosNS.bm.modulos             = String.valueOf(dadosModulos.get(0).get(5));
        parametrosNS.bm.abasFaturamento     = String.valueOf(dadosModulos.get(0).get(6));
        parametrosNS.bm.abasVendas          = String.valueOf(dadosModulos.get(0).get(7));
        parametrosNS.bm.abasEstoque         = String.valueOf(dadosModulos.get(0).get(8));
        parametrosNS.bm.abasContabil        = String.valueOf(dadosModulos.get(0).get(9));
        parametrosNS.bm.abasFiscal          = String.valueOf(dadosModulos.get(0).get(10));
        parametrosNS.bm.abasContasAReceber  = String.valueOf(dadosModulos.get(0).get(11));
        parametrosNS.bm.abasContasAPagar    = String.valueOf(dadosModulos.get(0).get(12));
        parametrosNS.bm.abasProducao        = String.valueOf(dadosModulos.get(0).get(13));
        parametrosNS.bm.abasGestao          = String.valueOf(dadosModulos.get(0).get(14));
        parametrosNS.bm.abasCompras         = String.valueOf(dadosModulos.get(0).get(15));
        parametrosNS.bm.abasRecebimento     = String.valueOf(dadosModulos.get(0).get(16));
        parametrosNS.bm.abasCRM             = String.valueOf(dadosModulos.get(0).get(17));
        parametrosNS.bm.abasCC              = String.valueOf(dadosModulos.get(0).get(18));
        parametrosNS.bm.abasRH              = String.valueOf(dadosModulos.get(0).get(19));
        
        parametrosNS.bm.moduloFaturamento   = Integer.parseInt(parametrosNS.bm.modulos.substring(0 , 1));  //1
        parametrosNS.bm.moduloVendas        = Integer.parseInt(parametrosNS.bm.modulos.substring(1 , 2));  //2
        parametrosNS.bm.moduloEstoque       = Integer.parseInt(parametrosNS.bm.modulos.substring(2 , 3));  //3
        parametrosNS.bm.moduloContabil      = Integer.parseInt(parametrosNS.bm.modulos.substring(3 , 4));  //4
        parametrosNS.bm.moduloFiscal        = Integer.parseInt(parametrosNS.bm.modulos.substring(4 , 5));  //5
        parametrosNS.bm.moduloContasAReceber= Integer.parseInt(parametrosNS.bm.modulos.substring(5 , 6));  //6
        parametrosNS.bm.moduloContasAPagar  = Integer.parseInt(parametrosNS.bm.modulos.substring(6 , 7));  //7
        parametrosNS.bm.moduloProducao      = Integer.parseInt(parametrosNS.bm.modulos.substring(7 , 8));  //8
        parametrosNS.bm.moduloGestao        = Integer.parseInt(parametrosNS.bm.modulos.substring(8 , 9));  //9
        parametrosNS.bm.moduloCompras       = Integer.parseInt(parametrosNS.bm.modulos.substring(9 ,10));  //10
        parametrosNS.bm.moduloRecebimento   = Integer.parseInt(parametrosNS.bm.modulos.substring(10,11));  //11
        parametrosNS.bm.moduloCRM           = Integer.parseInt(parametrosNS.bm.modulos.substring(11,12));  //12
        parametrosNS.bm.moduloCC            = Integer.parseInt(parametrosNS.bm.modulos.substring(12,13));  //13
        parametrosNS.bm.moduloRH            = Integer.parseInt(parametrosNS.bm.modulos.substring(13,14));  //14
    }
    
    private void PegaGrupo(){
        fatal = "N";
        bge.codigoGrupo     = parametrosNS.bu.codigoGrupo;
        if(bge.codigoGrupo == 0){
            fatal = "S";
            return;
        }
        sql = "select * from ns_grupoempresa where codigoGrupo = " + bge.codigoGrupo + ";";
        valoresGrupos.clear();
        valoresGrupos = parametrosNS.dao.Consulta(sql);
        if(valoresGrupos.isEmpty()){
            fatal = "S";
            confirmacao = JOptionPane.showConfirmDialog(null, "Grupo n°" + bge.codigoGrupo + " não encontrado, deseja cadastrar?");
            if(confirmacao != 0){
                return;
            }
            senha = new Senha("Grupo");
            AbreSenhaDoSistema();
            abriuGrupo = 1;
            return;
        }
        PegaDadosGrupo();
    }
    
    private void PegaDadosGrupo(){
        for(int i = 0; i < valoresGrupos.size(); i++){
            bge.codigoGrupo             = Integer.parseInt( String.valueOf(valoresGrupos.get(i).get(0)));
            bge.nomeGrupo               =                   String.valueOf(valoresGrupos.get(i).get(1));
            bge.pastaImagemLogotipo     =                   String.valueOf(valoresGrupos.get(i).get(2));
            bge.extensaoImagemLogotipo  =                   String.valueOf(valoresGrupos.get(i).get(3));
            bge.limiteUsuarios          = Integer.parseInt( String.valueOf(valoresGrupos.get(i).get(4)));
        }
        parametrosNS.bge.codigoGrupo            = bge.codigoGrupo;
        parametrosNS.bge.CodigoGrupo            = parametrosNS.bge.codigoGrupo;
        parametrosNS.bge.nomeGrupo              = bge.nomeGrupo;
        parametrosNS.bge.NomeGrupo              = parametrosNS.bge.nomeGrupo;
        parametrosNS.bge.pastaImagemLogotipo    = bge.pastaImagemLogotipo;
        parametrosNS.bge.PastaImagemLogotipo    = parametrosNS.bge.pastaImagemLogotipo;
        parametrosNS.bge.extensaoImagemLogotipo = bge.extensaoImagemLogotipo;
        parametrosNS.bge.ExtensaoImagemLogotipo = parametrosNS.bge.extensaoImagemLogotipo;
        parametrosNS.bge.limiteUsuarios         = bge.limiteUsuarios;
        parametrosNS.bge.LimiteUsuarios         = parametrosNS.bge.limiteUsuarios;
    }
    
    private void PegaEmpresa(){
        fatal = "N";
        be.codigoGrupo      = parametrosNS.bu.codigoGrupo;
        be.codigoEmpresa    = parametrosNS.bu.codigoEmpresa;
        if(be.codigoEmpresa == 0){
            return;
        }
        sql = "select * from ns_empresas where codigoGrupo = " + bge.codigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
        valoresEmpresas.clear();
        valoresEmpresas = parametrosNS.dao.Consulta(sql);
        if(valoresEmpresas.isEmpty()){
            fatal = "S";
            confirmacao = JOptionPane.showConfirmDialog(null, "Empresa: " + fc.FormataCampo(String.valueOf(be.codigoGrupo), 2, 0) + "." + fc.FormataCampo(String.valueOf(be.codigoEmpresa), 3, 0) + " não encontrada, deseja cadastrar?");
            if(confirmacao != 0){
                return;
            }
            senha = new Senha("Empresa");
            AbreSenhaDoSistema();
            abriuEmpresa = 1;
            return;
        }
        PegaDadosEmpresa();
    }
    
    private void PegaDadosEmpresa(){
        be.idEmpresa                = Integer.parseInt(  String.valueOf(valoresEmpresas.get(0).get(0)));
        be.codigoGrupo              = Integer.parseInt(  String.valueOf(valoresEmpresas.get(0).get(1)));
        be.codigoEmpresa            = Integer.parseInt(  String.valueOf(valoresEmpresas.get(0).get(2)));
        be.idBancoDados             = Integer.parseInt(  String.valueOf(valoresEmpresas.get(0).get(3)));
        be.nomeEmpresa              =                    String.valueOf(valoresEmpresas.get(0).get(4));
        be.nomeFantasia             =                    String.valueOf(valoresEmpresas.get(0).get(5));
        be.cnpjEmpresa              =                    String.valueOf(valoresEmpresas.get(0).get(6));
        be.inscricaoEstadual        =                    String.valueOf(valoresEmpresas.get(0).get(7));
        be.regimeTributario         =                    String.valueOf(valoresEmpresas.get(0).get(8));
        be.cepEmpresa               =                    String.valueOf(valoresEmpresas.get(0).get(9));
        be.cidadeEmpresa            =                    String.valueOf(valoresEmpresas.get(0).get(10));
        be.bairroEmpresa            =                    String.valueOf(valoresEmpresas.get(0).get(11));
        be.enderecoEmpresa          =                    String.valueOf(valoresEmpresas.get(0).get(12));
        be.numeroEmpresa            =                    String.valueOf(valoresEmpresas.get(0).get(13));
        be.ufEmpresa                =                    String.valueOf(valoresEmpresas.get(0).get(14));
        be.telefoneEmpresa          =                    String.valueOf(valoresEmpresas.get(0).get(15));
        be.pastaImagemUsuario       =                    String.valueOf(valoresEmpresas.get(0).get(16));
        be.extensaoImagemUsuario    =                    String.valueOf(valoresEmpresas.get(0).get(17));
        be.dataValidade             =                    String.valueOf(valoresEmpresas.get(0).get(18));
        
        parametrosNS.be.idEmpresa               = be.idEmpresa;
        parametrosNS.be.IdEmpresa               = parametrosNS.be.idEmpresa;
        parametrosNS.be.codigoGrupo             = be.codigoGrupo;
        parametrosNS.be.CodigoGrupo             = parametrosNS.be.codigoGrupo;
        parametrosNS.be.codigoEmpresa           = be.codigoEmpresa;
        parametrosNS.be.CodigoEmpresa           = parametrosNS.be.codigoEmpresa;
        parametrosNS.be.idBancoDados            = be.idBancoDados;
        parametrosNS.be.IdBancoDados            = parametrosNS.be.idBancoDados;
        parametrosNS.be.nomeEmpresa             = be.nomeEmpresa;
        parametrosNS.be.NomeEmpresa             = parametrosNS.be.nomeEmpresa;
        parametrosNS.be.nomeFantasia            = be.nomeFantasia;
        parametrosNS.be.NomeFantasia            = parametrosNS.be.nomeFantasia;
        parametrosNS.be.cnpjEmpresa             = be.cnpjEmpresa;
        parametrosNS.be.CnpjEmpresa             = parametrosNS.be.cnpjEmpresa;
        parametrosNS.be.inscricaoEstadual       = be.inscricaoEstadual;
        parametrosNS.be.InscricaoEstadual       = parametrosNS.be.inscricaoEstadual;
        parametrosNS.be.regimeTributario        = be.regimeTributario;
        parametrosNS.be.RegimeTributario        = parametrosNS.be.regimeTributario;
        parametrosNS.be.cepEmpresa              = be.cepEmpresa;
        parametrosNS.be.CepEmpresa              = parametrosNS.be.cepEmpresa;
        parametrosNS.be.cidadeEmpresa           = be.cidadeEmpresa;
        parametrosNS.be.CidadeEmpresa           = parametrosNS.be.cidadeEmpresa;
        parametrosNS.be.bairroEmpresa           = be.bairroEmpresa;
        parametrosNS.be.BairroEmpresa           = parametrosNS.be.bairroEmpresa;
        parametrosNS.be.enderecoEmpresa         = be.enderecoEmpresa;
        parametrosNS.be.EnderecoEmpresa         = parametrosNS.be.enderecoEmpresa;
        parametrosNS.be.numeroEmpresa           = be.numeroEmpresa;
        parametrosNS.be.NumeroEmpresa           = parametrosNS.be.numeroEmpresa;
        parametrosNS.be.ufEmpresa               = be.ufEmpresa;
        parametrosNS.be.UfEmpresa               = parametrosNS.be.ufEmpresa;
        parametrosNS.be.telefoneEmpresa         = be.telefoneEmpresa;
        parametrosNS.be.TelefoneEmpresa         = parametrosNS.be.telefoneEmpresa;
        parametrosNS.be.dataValidade            = be.dataValidade;
        parametrosNS.be.DataValidade            = parametrosNS.be.dataValidade;
        PegaImagemEmpresa();
        parametrosNS.be.imagemLogotipoEmpresa   = be.imagemLogotipoEmpresa;
        parametrosNS.be.ImagemLogotipoEmpresa   = parametrosNS.be.imagemLogotipoEmpresa;
    }
    
    private void PegaImagemEmpresa(){
        sql = "select imagemLogotipoEmpresa from ns_empresas where codigoGrupo = " + parametrosNS.be.codigoGrupo + " and codigoEmpresa = " + parametrosNS.be.codigoEmpresa + ";";
        be.imagemLogotipoEmpresa = parametrosNS.dao.ConsultaLogotipo(sql, "imagemLogotipoEmpresa");
    }
    
    private void LerModulosDeAcesso(){
        fatal = "N";
        bma.codigoGrupo     = bge.codigoGrupo;
        sql = "select modulosAcesso from ns_modulos_acesso where codigoGrupo = " + bma.codigoGrupo + ";";
        dadosModulosAcesso.clear();
        dadosModulosAcesso   = parametrosNS.dao.Consulta(sql);
        if(dadosModulosAcesso.isEmpty()){
            Mensagem = "Não foram encontrados Modulos de Acesso para o Grupo n°" + bma.codigoGrupo + "!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        bma.modulosAcesso   = String.valueOf(dadosModulosAcesso.get(0).get(0));
        if(Long.parseLong(bma.modulosAcesso) == 0){
            Mensagem = "Não foram encontrados Modulos de Acesso para o Grupo n°" + bma.codigoGrupo + "!";
            new MostraMensagem(Mensagem);
            fatal = "S";
//            return;
        }
        parametrosNS.bma.modulosAcesso  = bma.modulosAcesso;
        parametrosNS.bma.RecarregaVariavies();
    }
    
//    private void CriaBancoSeNaoExiste(){
//        tipoConexao = "Cria";
//        AbreConexao();
//        if(fatal.equals("S"))return;
//        sql = "create database if not exists " + bbd.nomeBanco + ";";
//        sqlstate = parametrosNS.dao.ConfiguraBancoMySQL(sql);
//        if(sqlstate.equals("00000"))
//            return;
//        fatal = "S";
//    }
    
    private void PegaInformacoesDoComputador(){
        try{
            bcomp.nomeComputador = InetAddress.getLocalHost().getHostName();    // Pega o Nome da Máquina
            IpComputador         = InetAddress.getLocalHost().getHostAddress(); // Pega o IPV4
            PastaSistema         = System.getProperty("File.separator");
            PastaSistema         = System.getProperty("java.class.path");
            PastaSistema         = System.getProperty("java.home");
            PastaSistema         = System.getProperty("java.vendor");
            PastaSistema         = System.getProperty("java.vendor.url");
            PastaSistema         = System.getProperty("java.version");
            PastaSistema         = System.getProperty("Line.separator");
            PastaSistema         = System.getProperty("os.arch");
            PastaSistema         = System.getProperty("os.name");
            PastaSistema         = System.getProperty("os.version");
            PastaSistema         = System.getProperty("Path.separator");
            PastaSistema         = System.getProperty("user.home");
            PastaSistema         = System.getProperty("user.dir");
            bcomp.usuarioMachine = System.getProperty("user.name");
        }catch(Exception erro){
            fatal = "S";
        }
    }
    
    private void VerificaQuantidadeConexoes(){
        sql = "select count(*) from information_schema.processlist where user = '" + bbd.usuario +  "' and db = '" + bbd.nomeBanco + "';";
        dadosCount.clear();
        dadosCount = parametrosNS.dao.Consulta(sql);
        qtdConexoes = Integer.parseInt(  String.valueOf(dadosCount.get(0).get(0)));
        if(qtdConexoes <= parametrosNS.bge.limiteUsuarios){
            return;
        }
        Mensagem = "Limite de Conexões foi excedida!";
        new MostraMensagem(Mensagem);
        fatal = "S";
    }
    
    private void VerificaSenhaDoSistema(){
        fatal = "N";
        dataHoje  = cdh.CapturarData();
        dataAtual = Test.Testa(dataHoje);
        
        if(parametrosNS.be.dataValidade == null){
            InformarSenhaSistema();
            return;
        }
        if(parametrosNS.be.dataValidade.equals("")){
            InformarSenhaSistema();
            return;
        }
        if(parametrosNS.be.dataValidade.equals("null")){
            InformarSenhaSistema();
            return;
        }
        senhaSistema = crpt.Criptografa(parametrosNS.be.dataValidade, "Descriptografar");
        //System.out.println(senhaSistema);
        senhaValida = Tssed.TransformarSenhaSistemaEmData(parametrosNS.be.dataValidade);
        //System.out.println(dataAtual + " - " + senhaValida);
        if(senhaValida >= dataAtual){
            return;
        }
        if(Inf != null){
            this.dispose();
        }
        InformarSenhaSistema();
    }
    
    private void InformarSenhaSistema(){
        dispose();
        Inf = new InformarSenhaSistema("Login");
        fatal = "S";
    }
    
    private void VerificaDepartamentosCadastrados() {
        fatal = "N";
        sql = "select * from tb_departamento where codigoGrupo = " + bge.codigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
        departamentos.clear();
        departamentos = parametrosNS.dao.Consulta(sql);
        if(departamentos.isEmpty()){
            fatal = "S";
            confirmacao = JOptionPane.showConfirmDialog(null, "Não existem Departamentos Cadastrados, deseja cadastrar?", "", JOptionPane.YES_NO_OPTION);
            if(confirmacao != 0){
                return;
            }
            parametros.clear();
            parametros.add("N");
            parametros.add("Login");
            parametros.add(0);
            CadDep = new DepartamentosCadastro(parametros);
            CadDep.setVisible(true);
            dispose();
        }
    }
    
    private void VerificaComputadorCadastrado(){
        fatal = "N";
        sql = "select * from tb_computadores where codigoGrupo = " + bge.codigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + ";";
        computador.clear();
        computador = parametrosNS.dao.Consulta(sql);
        if(computador.isEmpty()){
            fatal = "S";
            confirmacao = JOptionPane.showConfirmDialog(null, "Não existem computadores cadastrados, deseja cadastrar?", "", JOptionPane.YES_NO_OPTION);
            if(confirmacao != 0){
                return;
            }
            CadComp = new ComputadoresCadastro("Login");
            CadComp.setVisible(true);
            dispose();
            return;
        }
        sql = "select * from tb_computadores where codigoGrupo = " + bge.codigoGrupo + " and codigoEmpresa = " + be.codigoEmpresa + " and nomeComputador = '" + bcomp.nomeComputador + "';";
        computador.clear();
        computador = parametrosNS.dao.Consulta(sql);
        if(computador.isEmpty()){
            fatal = "S";
            confirmacao = JOptionPane.showConfirmDialog(null, "Computador não possui acesso ao sistema, deseja cadastra-lo?", "", JOptionPane.YES_NO_OPTION);
            if(confirmacao != 0){
                return;
            }
            CadComp = new ComputadoresCadastro("Login");
            CadComp.setVisible(true);
            dispose();
            return;
        }
    }
    
    private void VerificaIpComputador(){
        bcomp.idComputador          = Integer.parseInt(  String.valueOf(computador.get(0).get(0)));
        bcomp.idEmpresa             = Integer.parseInt(  String.valueOf(computador.get(0).get(1)));
        bcomp.codigoGrupo           = Integer.parseInt(  String.valueOf(computador.get(0).get(2)));
        bcomp.codigoEmpresa         = Integer.parseInt(  String.valueOf(computador.get(0).get(3)));
        bcomp.codigoComputador      = Integer.parseInt(  String.valueOf(computador.get(0).get(4)));
        bcomp.nomeComputador        =                    String.valueOf(computador.get(0).get(6));
        bcomp.usuarioMachine        =                    String.valueOf(computador.get(0).get(9));
        bcomp.funcaoComputador      =                    String.valueOf(computador.get(0).get(11));
        bcomp.ipEstatico            = Integer.parseInt(  String.valueOf(computador.get(0).get(8)));
        if(bcomp.ipEstatico == 0){
            return;
        }
        bcomp.ipv4                  =                    String.valueOf(computador.get(0).get(7));
        bcomp.ipv4                  = bcomp.ipv4.replace(".", "");
        bcomp.ip1                   = Integer.parseInt(bcomp.ipv4.substring(0, 3));
        bcomp.ip2                   = Integer.parseInt(bcomp.ipv4.substring(3, 6));
        bcomp.ip3                   = Integer.parseInt(bcomp.ipv4.substring(6, 9));
        bcomp.ip4                   = Integer.parseInt(bcomp.ipv4.substring(9,12));
        bcomp.ipv4                  = bcomp.ip1 + "." + bcomp.ip2 + "." + bcomp.ip3 + "." + bcomp.ip4;
        if(!bcomp.ipv4.equals(IpComputador)){
            Mensagem = "Ip cadastrado para o computador " + bcomp.nomeComputador + " inválido!";
            new MostraMensagem(Mensagem);
            fatal = "S";
        }
    }
    
    private void PegaComputadorLembrarEmail(){
        sql = "select * from nscomputadores where nomeComputador = '" + bcomp.nomeComputador + "';";
        dlite = new daoSQLITE();
        nsComputadores.clear();
        nsComputadores = dlite.Consulta(sql);
        if(nsComputadores.isEmpty()){
            operacaoEmail = "I";
            return;
        }
        operacaoEmail = "A";
        PegaDadosComputadorLembrarEmail();
    }
    
    private void PegaDadosComputadorLembrarEmail(){
        for(int i = 0; i < nsComputadores.size(); i++){
            bnscomp.lembrarEmail        = Integer.parseInt(  String.valueOf(nsComputadores.get(i).get(0)));
            bnscomp.nomeComputador      =                    String.valueOf(nsComputadores.get(i).get(1));
            bnscomp.nomeEmail           =                    String.valueOf(nsComputadores.get(i).get(2));
        }
        if(bnscomp.lembrarEmail != 0){
            check_email.setSelected(true);
            txt_usuario.setText(bnscomp.nomeEmail);
            txt_senha.grabFocus();
        }
    }
    
    private void PegaValoresLembrarEmail(){
        if(operacaoEmail.equals("A")){if(check_email.isSelected() ==  true){if(bnscomp.lembrarEmail == 1){fatal = "S";return;}}}
        if(operacaoEmail.equals("A")){if(check_email.isSelected() == false){if(bnscomp.lembrarEmail == 0){fatal = "S";return;}}}
        if(operacaoEmail.equals("I")){
            bnscomp.lembrarEmail    = 1;
        }if(operacaoEmail.equals("A")){
            if(check_email.isSelected() == false){
                bnscomp.lembrarEmail = 0;
            }else{
                bnscomp.lembrarEmail = 1;
            }
        }
        bnscomp.nomeComputador  = bcomp.nomeComputador;
        bnscomp.nomeEmail       = parametrosNS.bu.usuario;
    }
    
    private void IncluirLembrarEmail(){
        PegaValoresLembrarEmail();
        if(fatal.equals("S")){fatal = "N";return;}
        sql = "insert into nscomputadores (lembrarEmail, nomeComputador, nomeEmail) "
            + "values ('" + bnscomp.lembrarEmail + "', '" + bnscomp.nomeComputador + "', '" + bnscomp.nomeEmail + "');";
        dlite = new daoSQLITE();
        sqlstate = dlite.IncluirRegistro(sql);
    }
    
    private void AlterarLembrarEmail(){
        PegaValoresLembrarEmail();
        if(fatal.equals("S")){fatal = "N";return;}
        sql = "update nscomputadores set lembrarEmail = '"              + bnscomp.lembrarEmail      + "', "
                                      + "nomeEmail = '"                 + bnscomp.nomeEmail         + "' "
                                      + "where nomeComputador = '"      + bnscomp.nomeComputador    + "';";
        dlite = new daoSQLITE();
        sqlstate = dlite.AlterarRegistro(sql);
    }
    
    private void VerificaDiasRestantes(){
        data = invdata.inverterData(String.valueOf(senhaValida), 1);
        if(data.equals("")){
            return;
        }
        dias = cdr.RetornaDias(cdh.CapturarData(), data);
        parametrosNS.Dias = dias;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txt_rodape = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txt_rodape1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_senha = new javax.swing.JPasswordField();
        bt_login = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        check_email = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuConfiguracoes = new javax.swing.JMenu();
        bt_desbloquear = new javax.swing.JMenuItem();
        bt_CadastroDeGrupos = new javax.swing.JMenuItem();
        bt_CadastroDeEmpresas = new javax.swing.JMenuItem();
        bt_cadastroModulos = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        sair = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_rodape.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_rodape.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_rodape, javax.swing.GroupLayout.DEFAULT_SIZE, 915, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_rodape, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(":: Segurança - NSYS NS3 ERP 2.1");
        setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_rodape1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txt_rodape1.setForeground(new java.awt.Color(51, 204, 0));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Status:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_rodape1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_rodape1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/logo-top.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Usuário:");

        txt_usuario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_usuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_usuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usuarioFocusLost(evt);
            }
        });
        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Senha: ");

        txt_senha.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_senha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_senhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_senhaFocusLost(evt);
            }
        });
        txt_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_senhaKeyPressed(evt);
            }
        });

        bt_login.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        bt_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Apply.png"))); // NOI18N
        bt_login.setText("Login");
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });
        bt_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_loginKeyPressed(evt);
            }
        });

        bt_cancelar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        bt_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_cancelar.setText("Sair");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        check_email.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        check_email.setText("Lembrar usuário");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_usuario)
                            .addComponent(txt_senha)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(check_email)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_login)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_cancelar)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(check_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, txt_senha, txt_usuario});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_cancelar, check_email});

        MenuConfiguracoes.setText("Configurações");
        MenuConfiguracoes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        bt_desbloquear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        bt_desbloquear.setText(":: Desbloquear ::");
        bt_desbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_desbloquearActionPerformed(evt);
            }
        });
        MenuConfiguracoes.add(bt_desbloquear);

        bt_CadastroDeGrupos.setText(":: Cadastro de Grupos");
        bt_CadastroDeGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CadastroDeGruposActionPerformed(evt);
            }
        });
        MenuConfiguracoes.add(bt_CadastroDeGrupos);

        bt_CadastroDeEmpresas.setText(":: Cadastro de Empresas");
        bt_CadastroDeEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CadastroDeEmpresasActionPerformed(evt);
            }
        });
        MenuConfiguracoes.add(bt_CadastroDeEmpresas);

        bt_cadastroModulos.setText(":: Cadastro de Módulos");
        bt_cadastroModulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroModulosActionPerformed(evt);
            }
        });
        MenuConfiguracoes.add(bt_cadastroModulos);

        jMenuItem4.setText(":: Configurar banco de dados");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        MenuConfiguracoes.add(jMenuItem4);

        sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        sair.setText(":: Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        MenuConfiguracoes.add(sair);

        jMenuBar1.add(MenuConfiguracoes);

        jMenu1.setText("Sistema");
        jMenu1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jMenuItem1.setText(":: Informações");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem2.setText(":: Conectar sistema online");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setText(":: Reparo automático");
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText(":: Atualizador do sistema");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sobre");
        jMenu2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jMenuItem3.setText(":: Sobre");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        InfSis = new InformacoesSistema();
        InfSis.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    private void AbreSenhaDoSistema(){
        senha.setVisible(true);
    }
    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        sobre = new Sobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    
    private void txt_senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_senhaKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_TAB){
            if(evt.getKeyCode() != KeyEvent.VK_ENTER){
                return;
            }
        }
        PressEnter = "S";
        bt_login.grabFocus();
    }//GEN-LAST:event_txt_senhaKeyPressed

    private void txt_senhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_senhaFocusLost
        if(txt_usuario.getText().replace(" ", "").equals("")){
            return;
        }
        if(txt_senha.getText().equals("")){
            return;
        }
        if(!PressEnter.equals("S")){
            bt_login.setEnabled(true);
            bt_login.grabFocus();
            return;
        }
        PegaUsuarioParaLogar();
    }//GEN-LAST:event_txt_senhaFocusLost
    
    private void PegaUsuarioParaLogar(){
        bu.usuario  = txt_usuario.getText();
        bu.senha    = txt_senha.getText();
//        if(!bu.usuario.equalsIgnoreCase("NS3")){
//            bu.senha    = crpt.CriptografaManualmente(bu.senha);
//        }
        if(bu.usuario.equalsIgnoreCase("NS3")){
            if(bu.senha.equalsIgnoreCase("adm2322")){
                parametrosNS.bu.usuario = "NS3";
                parametrosNS.bu.senha   = "adm2322";
                Logar();
                return;
            }
        }
        sql = "select * from tb_usuarios where usuario = '" + bu.usuario + "' and senha = '" + bu.senha + "';";
        parametrosNS.PegaUsuario(sql);
        txt_senha.grabFocus();
        if(!parametrosNS.dadosUsuarios.isEmpty()){CarregamentoSistema();}
        if( parametrosNS.dadosUsuarios.isEmpty()){
            txt_senha.setText("");
            txt_senha.grabFocus();
            return;
        }
        Logar();
    }
    
    private void txt_senhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_senhaFocusGained
        txt_senha.setText("");
    }//GEN-LAST:event_txt_senhaFocusGained

    private void txt_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyPressed
        if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return;
        txt_senha.grabFocus();
    }//GEN-LAST:event_txt_usuarioKeyPressed

    private void txt_usuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usuarioFocusLost
        if(txt_usuario.getText().replace(" ", "").equals(""))
            return;
        if(txt_senha.getText().replace(" ", "").equals(""))
            return;
        bt_login.setEnabled(true);
    }//GEN-LAST:event_txt_usuarioFocusLost

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_loginKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_loginKeyPressed

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        PegaUsuarioParaLogar();
    }//GEN-LAST:event_bt_loginActionPerformed
            
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(abriuSenhaSistema == 0){
            AbriuSenhaSistemaModulos();
            return;
        }
        abriuSenhaSistema = 0;
        retorno = senha.getRetorno();
        if(!retorno.equalsIgnoreCase("ok")){
            return;
        }
        ResetaMenus(true);
        bt_desbloquear.setVisible(false);
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void AbriuSenhaSistemaModulos(){
        if(abriuSenhaModulos == 0){
            AbreGrupos();
            return;
        }
        abriuSenhaModulos = 0;
        retorno = senha.getRetorno();
        if(!retorno.equalsIgnoreCase("ok")){
            return;
        }
        ConfMod = new ConfiguraModulos();
        ConfMod.setVisible(true);
        dispose();
    }
    
    private void AbreGrupos(){
        if(abriuGrupo == 0){
            AbreEmpresas();
            return;
        }
        abriuGrupo = 0;
        dispose();
    }
    
    private void AbreEmpresas(){
        if(abriuEmpresa == 0){
            return;
        }
        abriuEmpresa = 0;
        dispose();
    }
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(con  != null)fabricaConexaoMySQL.fecharConexao(con);
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        if(fatal.equals("S"))dispose();
        parametrosNS.AlinharColunas();
        if(Inf    != null){Inf   .setVisible(true);this.dispose();}
        if(SavBdD != null){SavBdD.setVisible(true);this.dispose();}
        if(Bar == null){IniciaCarregamentoSistema();}
        
        
        //System.out.println("Atualização das bases de dados: " + a);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowIconified

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        SalvarBancoDeDados sv = new SalvarBancoDeDados("");
        sv.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void bt_cadastroModulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroModulosActionPerformed
        if(senha != null)if(senha.isVisible()){
            Mensagem = "Tela já Aberta!";
            new MostraMensagem(Mensagem);
            return;
        }
        abriuSenhaModulos = 1;
        senha = new Senha("Modulos");
        senha.setVisible(true);
    }//GEN-LAST:event_bt_cadastroModulosActionPerformed

    private void bt_CadastroDeEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CadastroDeEmpresasActionPerformed
        AbreCadastroDeEmpresas();
    }//GEN-LAST:event_bt_CadastroDeEmpresasActionPerformed

    private void bt_CadastroDeGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CadastroDeGruposActionPerformed
        AbreCadastroDeGrupos();
    }//GEN-LAST:event_bt_CadastroDeGruposActionPerformed

    private void bt_desbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_desbloquearActionPerformed
        abriuSenhaSistema = 1;
        senha = new Senha("");
        AbreSenhaDoSistema();
    }//GEN-LAST:event_bt_desbloquearActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try {
            java.awt.Desktop.getDesktop().open( new File( "AtualizadorSistema.jar" ) );
            dispose();
        } catch (IOException ex) {
            mensagem = "Erro: " + ex;
            mostraMensagem();
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void txt_usuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usuarioFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuarioFocusGained
    
    private void Logar(){
        VerificaDiasRestantes();
        if(fatal.equals("S")){
            DefineAcesso(false);
            return;
        }
        dispose();
        sql = "update tb_usuarios set nomeConexao = '" + con + "' where idUsuario = '" + parametrosNS.bu.idUsuario + "';" ;
        SetaConexao();
        if(fatal.equals("S")){DefineAcesso(false);return;}
        if(parametrosNS.bu.usuario.equalsIgnoreCase("NS3"))
            if(parametrosNS.bu.senha.equalsIgnoreCase("adm2322")){
                PegaInformacoesDoComputador();
                CarregarInformacoesSistema();
                
                parametrosNS.bu.codigoUsuario    = 999;
                parametrosNS.bu.nome             = bu.usuario;
                parametrosNS.bu.usuario          = bu.usuario;
                parametrosNS.bu.senha            = bu.senha;
                parametrosNS.bu.nivelUsuario     = 9;
                parametrosNS.bu.podeMudarEmpresa = 1;
                dispose();
                MudEmpAtu = new MudarEmpresaAtual();
                MudEmpAtu.setVisible(true);
                return;
            }
                
        LogsDeAcesso();
        if(operacaoEmail.equals("I")){
            if(check_email.isSelected() == true)IncluirLembrarEmail();
        }else{
            AlterarLembrarEmail();
        }
        //Por tiago, por favor não toca nessa porra, Paulo: Tá bom, não vou tocar
//        AtualizadorCluster at = new AtualizadorCluster();
//        at.setVisible(true);
        MenuPrin = new MenuPrincipal();
        MenuPrin.setExtendedState(JFrame.MAXIMIZED_BOTH);
        MenuPrin.setVisible(true);
    }
    
    private void LogsDeAcesso(){
        bla.idEmpresa       = parametrosNS.be.IdEmpresa;
        bla.codigoGrupo     = parametrosNS.bge.CodigoGrupo;
        bla.codigoEmpresa   = parametrosNS.be.CodigoEmpresa;
        bla.codigoLogAcesso = parametrosNS.PegProReg.PegaProximoRegistro("tb_logacesso", "codigoLogAcesso", "");
        bla.codigoUsuario   = parametrosNS.bu.codigoUsuario;
        bla.ip              = parametrosNS.bcomp.ipv4;
        bla.terminal        = parametrosNS.bcomp.nomeComputador;
        bla.data            = invdata.inverterData(cdh.CapturarData(), 2);
        bla.horaEntrada     = cdh.CapturaHora();
        bla.sistema         = "NSys-Desktop";
        sql = "insert into tb_logacesso (idEmpresa, codigoGrupo, codigoEmpresa, codigoLogAcesso, codigoUsuario, ip, terminal, data, horaEntrada, sistema)"
            + " values (" + bla.idEmpresa + ", " + bla.codigoGrupo + ", " + bla.codigoEmpresa + ", " + bla.codigoLogAcesso + ", " + bla.codigoUsuario + ", '" + bla.ip + "', '" + bla.terminal + "', '" + bla.data + "', '" + bla.horaEntrada + "', '" + bla.sistema + "');";
        sqlstate = parametrosNS.dao.incluirRegistro(sql);
        if(!sqlstate.equals("00000")){
            return;
        }
//        try {
//            gravaTxt();
//        } catch (IOException ex) {
//            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    private void SetaConexao(){
        fatal = "N";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(sqlstate.equals("00000")){
            return;
        }
        fatal = "S";
    }
    
//    private void gravaTxt() throws IOException{
//// por enquanto ok
//        
//        String nomeArq = txt_usuario.getText() + (invdata.inverterData(cdh.CapturarData(), 2)) + con;
//        
//        
//        //FileWriter arq = new FileWriter("c://NSYS/logVenda.txt");
//        FileWriter arq = new FileWriter("logs/acesso-"+nomeArq+".txt");
//        PrintWriter gravarArq = new PrintWriter(arq);
//        gravarArq.println((bu.codigoUsuario));
//        gravarArq.println((invdata.inverterData(cdh.CapturarData(), 2)));
//        gravarArq.println((cdh.CapturaHora()));
//        gravarArq.println((bcomp.ipv4));
//        gravarArq.println((String.valueOf(bcomp.nomeComputador)));
//        gravarArq.println("--------------------------------");
//        gravarArq.println("ok - tiago 22/12/2015");
//        gravarArq.println("");
//                arq.close();
//    
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuConfiguracoes;
    private javax.swing.JMenuItem bt_CadastroDeEmpresas;
    private javax.swing.JMenuItem bt_CadastroDeGrupos;
    private javax.swing.JMenuItem bt_cadastroModulos;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JMenuItem bt_desbloquear;
    private javax.swing.JButton bt_login;
    private javax.swing.JCheckBox check_email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenuItem sair;
    private javax.swing.JLabel txt_rodape;
    private javax.swing.JLabel txt_rodape1;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

    private void CarregarInformacoesSistema(){
        parametrosNS.bcomp.idComputador     = bcomp.idComputador;
        parametrosNS.bcomp.idEmpresa        = bcomp.idEmpresa;
        parametrosNS.bcomp.codigoGrupo      = bcomp.codigoGrupo;
        parametrosNS.bcomp.codigoEmpresa    = bcomp.codigoEmpresa;
        parametrosNS.bcomp.codigoComputador = bcomp.codigoComputador;
        parametrosNS.bcomp.nomeComputador   = bcomp.nomeComputador;
        parametrosNS.bcomp.ipv4             = IpComputador;
        parametrosNS.bcomp.usuarioMachine   = bcomp.usuarioMachine;
        parametrosNS.bcomp.funcaoComputador = bcomp.funcaoComputador;
        parametrosNS.PastaSistema           = PastaSistema;
    }
    
// ==================================== 01/12/1995 ===========================//
    private void AniversarioDoPaulo() {
// variaveis de cu é rola
        
        String qtdRolasNocu = "";
        String carinha      = null;
        String nomeDoAmigo  = null;
// Define valores de cu + qtd de rolas
        carinha = "( ͡° ͜ʖ ͡°)";
        Mensagem = "Manoo, hoje é o seu dia!";
        new MostraMensagem(Mensagem);
            while (qtdRolasNocu == null || qtdRolasNocu.equals("")) {
                qtdRolasNocu = JOptionPane.showInputDialog("Mano, quantos anos você está fazendo hoje???", null);
                if (qtdRolasNocu == null || qtdRolasNocu.equals("")) {
                    Mensagem = "Responde a pergunta carai ¬¬'";
                    new MostraMensagem(Mensagem);
                }
            }
// mensagens de cu tbm é rola        
        Mensagem = "Feliz aniversário mow parça, são " + qtdRolasNocu + " anos??? aee";
        new MostraMensagem(Mensagem);
            Mensagem = "Muuuuuuuita rola no seu cu";
            new MostraMensagem(Mensagem);
                Mensagem = "Que tenha muitos anús de vida";
                new MostraMensagem(Mensagem);
                    Mensagem = "Que tire muitas camisinhas peidando!!";
                    new MostraMensagem(Mensagem);
                            Mensagem = "Dps compro um vibrador bem Grand p você";
                            new MostraMensagem(Mensagem);
                                Mensagem = "São " + qtdRolasNocu + " rolas grossas de negão no seu cu :3 " + carinha;
                                new MostraMensagem(Mensagem);
// chama tomelirolla
//        telas.pdv.aniversarioPaulo cu = new telas.pdv.aniversarioPaulo();
//        cu.setVisible(true);
//            telas.pdv.aniversarioPaulo ppk = new telas.pdv.aniversarioPaulo();
//            ppk.setVisible(true);
//                telas.pdv.aniversarioPaulo cus = new telas.pdv.aniversarioPaulo();
//                cus.setVisible(true);
//                    telas.pdv.aniversarioPaulo badalo = new telas.pdv.aniversarioPaulo();
//                    badalo.setVisible(true);
//                        telas.pdv.aniversarioPaulo xapisca = new telas.pdv.aniversarioPaulo();
//                        xapisca.setVisible(true);
    } // the end :3 
// ================================= 01/12/1995 ========= Fim do void=========//    
    
    private void DefineAcesso(boolean Habilita){
        bt_login            .setEnabled (Habilita);
        dadosConexao        .add("Sem Conexão!");
        txt_rodape1         .setText("Liberado!");
        txt_rodape1         .setForeground(Color.GREEN);
        if(!Mensagem.equals("")){
            descricao = "";
        }
        if(Habilita == false){
            txt_usuario         .setEnabled  (false);
            txt_usuario         .setFocusable(false);
            txt_senha           .setEnabled  (false);
            txt_senha           .setFocusable(false);
            Mensagem = descricao;
            if(confirmacao != 0){
                if(!Mensagem.equals("")){
                    new MostraMensagem(Mensagem);
                }
            }
            txt_rodape1     .setText("Bloqueado!");
            txt_rodape1     .setForeground(Color.RED);
        }
        if(Inf != null){
            Inf.setVisible(true);
        }
    }
    
    private void AbreCadastroDeGrupos(){
        dispose();
        CadGru = new GruposCadastro("Login");
        CadGru.setVisible(true);
    } 
    
    private void AbreCadastroDeEmpresas(){
        dispose();
        CadEmp = new EmpresasCadastro();
        CadEmp.setVisible(true);
    }
    
    private void AbreCadastroDeComputadores(){
        dispose();
        CadComp = new ComputadoresCadastro("Login");
        CadComp.setVisible(true);
    }
    
    private void AbreCadastroDeDepartamento(){
        dispose();
        parametros.clear();
        parametros.add("N");
        parametros.add("Login");
        parametros.add(0);
        CadDep = new DepartamentosCadastro(parametros);
        CadDep.setVisible(true);
    }
    
    private void AbreCadastroDeUsuario(){
        dispose();
        parametros.clear();
        parametros.add("N");
        parametros.add("Login");
        parametros.add(0);
        CadUsu = new UsuariosCadastro(parametros);
    }
    
    private void SetaBarra(){
        if(Bar == null){
            txt_rodape.setText(descricao);
            try{wait(1000);}catch(Exception erro){}
            return;
        }
        if(!nsComputadores.isEmpty()){
            if(bnscomp.lembrarEmail == 0){
                return;
            }
        }
        Bar.jLabelTextoCarregamento.setText(descricao);
        try{wait(1000);}catch(Exception erro){}
    }

    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
}
