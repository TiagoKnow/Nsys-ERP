package Parametros;

import BeansNS.BeanBancoDados;
import Beans.BeanComputadores;
import BeansNS.BeanEmpresas;
import BeansNS.BeanGrupoEmpresa;
import Beans.BeanModulos;
import BeansNS.BeanModulosAcesso;
import Beans.BeanUsuarios;
import Beans.BeanUsuariosEmail;
import Dao.DaoMySQL;
import Dao.DaoTabelas;
import FuncoesInternas.CapturarDataHora;
import FuncoesInternas.Criptografia;
import FuncoesInternas.FormataCPFCNPJ;
import FuncoesInternas.FormataCampo;
import FuncoesInternas.FormataCampoCpfCnpj;
import FuncoesInternas.FormataPorcentagem;
import FuncoesInternas.InverterData;
import FuncoesInternas.MostraMensagem;
import FuncoesInternas.PegaProximoRegistro;
import FuncoesInternas.PesquisaAvancada;
import FuncoesInternas.TestarData;
import FuncoesInternas.TransformaValorStringeDouble;
import FuncoesInternas.ValidarCpfCnpj;
import FuncoesInternas.ValidarData;
import FuncoesInternas.ValidarRG;
import daoConexao.fabricaConexaoMySQL;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
/*
 @author Tiago e Paulo
 */
public class parametrosNS {
    //Connection
    public static Connection con;
    
    //String
    public  static String sql          = "";
    public  static String PastaSistema = "";
    public  static String Mensagem     = "";
    public  static String gsAlert      = "";
    private static String addUsu       = "";
    
    //int
//    public static int    User          = 0;
    public static int    codigoOS      = 0;
    public static int    codigoCliente = 0;
    public static String cpfCnpj       = "";
    
    //Long
    public static long   Dias = 0;
    
    //Tabelas
    public static DefaultTableCellRenderer tableEsquerda      = new DefaultTableCellRenderer();
    public static DefaultTableCellRenderer tableCentralizado  = new DefaultTableCellRenderer();
    public static DefaultTableCellRenderer tableDireita       = new DefaultTableCellRenderer();
    
    //Vetores
    public  static ArrayList            dadosReconexao    = new ArrayList<Object>();
    public  static ArrayList<ArrayList> dadosUsuarios     = new ArrayList();
    private static ArrayList<ArrayList> dadosUsuarioEmail = new ArrayList();
    private static ArrayList<ArrayList> dadosModulos      = new ArrayList();
    
    //Bean's
    public static BeanBancoDados    bbd     = new BeanBancoDados();
    public static BeanGrupoEmpresa  bge     = new BeanGrupoEmpresa();
    public static BeanEmpresas      be      = new BeanEmpresas();
    public static BeanComputadores  bcomp   = new BeanComputadores();
    public static BeanModulos       bm      = new BeanModulos();
    public static BeanModulosAcesso bma     = new BeanModulosAcesso();
    public static BeanUsuarios      bu      = new BeanUsuarios();
    public static BeanUsuariosEmail bue     = new BeanUsuariosEmail();
    
    //Dao's
    public static DaoMySQL dao;
    public static DaoTabelas dtab;
    
    //Especiais
    public static CapturarDataHora             cdh           = new CapturarDataHora();
    public static Criptografia                 crpt          = new Criptografia();
    public static InverterData                 invdata       = new InverterData();
    public static ValidarRG                    ValRG         = new ValidarRG();
    public static FormataCampo                 fc            = new FormataCampo();
    public static FormataCPFCNPJ               FCpfCnpj      = new FormataCPFCNPJ();
    public static TestarData                   Test          = new TestarData();
    public static TransformaValorStringeDouble TransStrDou   = new TransformaValorStringeDouble();
    public static ValidarCpfCnpj               Vcc           = new ValidarCpfCnpj();
    public static PegaProximoRegistro          PegProReg     = new PegaProximoRegistro();
    public static FormataCampoCpfCnpj          FCampoCpfCnpj = new FormataCampoCpfCnpj();
    public static ValidarData                  ValData       = new ValidarData();
    public static FormataPorcentagem           FcPor         = new FormataPorcentagem();
    public static PesquisaAvancada             PesqAvan      = new PesquisaAvancada();
    
    @SuppressWarnings("empty-statement")
    public static void RecarregaConexao(){
        dadosReconexao.clear();
        dadosReconexao.add(bbd.servidor);
        dadosReconexao.add(bbd.porta);
        dadosReconexao.add(bbd.usuario);
        dadosReconexao.add(bbd.senha);
        dadosReconexao.add(bbd.nomeBanco);
        for(int i = 1; i < 4; i++){
            JOptionPane.showMessageDialog(null, "Tentativa: " + i + " de 3", "Reconectando Sistema", JOptionPane.OK_OPTION);
            
            con = fabricaConexaoMySQL.AbrirConexao(dadosReconexao);
            if(con != null){
                dao.sqlstate = "00000";
                return;
            }
        }
        if(con == null){
            Mensagem = "Impossível Reconectar o Sistema!\nEntre em contato com o administrador do sistema!";
            new MostraMensagem(Mensagem);
            System.exit(0);
            return;
        }
        dao.sqlstate = "00000";
    }
    
    public static void AlinharColunas(){
        tableEsquerda       .setHorizontalAlignment(SwingConstants.LEFT);
        tableCentralizado   .setHorizontalAlignment(SwingConstants.CENTER);
        tableDireita        .setHorizontalAlignment(SwingConstants.RIGHT);
    }
    
    private static void mostraMensagem(){
        JOptionPane.showMessageDialog(null, Mensagem);
    }
    
    public static void PegaUsuario(String Sql){
        gsAlert = "N";
        sql = "select * from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + parametrosNS.bu.codigoUsuario + ";";
        if(!Sql.equals("")){
            sql = Sql;
        }
        addUsu = "N";
        dadosUsuarios.clear();
        dadosUsuarios = parametrosNS.dao.Consulta(sql);
        if(dadosUsuarios.isEmpty()){
            addUsu = "S";
            sql = "select * from tb_usuarios where idEmpresa = " + parametrosNS.be.idEmpresa + " and codigoUsuario = " + parametrosNS.bu.codigoUsuario + ";";
            dadosUsuarios.clear();
            dadosUsuarios = parametrosNS.dao.Consulta(sql);
            if(dadosUsuarios.isEmpty()){
                Mensagem = "Usuário não encontrado!";
                mostraMensagem();
                return;
            }
        }
        PegaDadosUsuarios();
    }
    
    private static void PegaDadosUsuarios(){
        for(int i = 0; i < dadosUsuarios.size(); i++){
            if(dadosUsuarios.get(i).get(0)  != null){bu.idUsuario            = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(0)));}
            if(dadosUsuarios.get(i).get(1)  != null){bu.idEmpresa            = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(1)));}
            if(dadosUsuarios.get(i).get(2)  != null){bu.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(2)));}
            if(dadosUsuarios.get(i).get(3)  != null){bu.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(3)));}
            if(dadosUsuarios.get(i).get(4)  != null){bu.codigoUsuario        = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(4)));}
            if(dadosUsuarios.get(i).get(5)  != null){bu.dataCriacao          =                    String.valueOf(dadosUsuarios.get(i).get(5));}
            if(dadosUsuarios.get(i).get(6)  != null){bu.nome                 =                    String.valueOf(dadosUsuarios.get(i).get(6));}
            if(dadosUsuarios.get(i).get(7)  != null){bu.usuario              =                    String.valueOf(dadosUsuarios.get(i).get(7));}
            if(dadosUsuarios.get(i).get(8)  != null){bu.senha                =                    String.valueOf(dadosUsuarios.get(i).get(8));}
            if(dadosUsuarios.get(i).get(9)  != null){bu.telefone             =                    String.valueOf(dadosUsuarios.get(i).get(9));}
            if(dadosUsuarios.get(i).get(10) != null){bu.codigoDepartamento   = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(10)));}
            if(dadosUsuarios.get(i).get(11) != null){bu.nivelUsuario         = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(11)));}
            if(dadosUsuarios.get(i).get(12) != null){bu.podeMudarEmpresa     = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(12)));}
            if(dadosUsuarios.get(i).get(13) != null){bu.observacoes          =                    String.valueOf(dadosUsuarios.get(i).get(13));}
            if(dadosUsuarios.get(i).get(14) != null){bu.nomeConexao          =                    String.valueOf(dadosUsuarios.get(i).get(14));}
            if(dadosUsuarios.get(i).get(15) != null){bu.dataAlterou          =                    String.valueOf(dadosUsuarios.get(i).get(15));}
            if(dadosUsuarios.get(i).get(16) != null){bu.horaAlterou          =                    String.valueOf(dadosUsuarios.get(i).get(16));}
            if(dadosUsuarios.get(i).get(17) != null){bu.usuarioAlterou       = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(17)));}
            if(dadosUsuarios.get(i).get(18) != null){bu.idEmpresaAlterou     = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(18)));}
            if(dadosUsuarios.get(i).get(19) != null){bu.codigoGrupoAlterou   = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(19)));}
            if(dadosUsuarios.get(i).get(20) != null){bu.codigoEmpresaAlterou = Integer.parseInt(  String.valueOf(dadosUsuarios.get(i).get(20)));}
        }
        PegaImagemUsuario();
        
        bue.idEmpresa       = bu.idEmpresa;
        bue.codigoGrupo     = bu.codigoGrupo;
        bue.codigoEmpresa   = bu.codigoEmpresa;
        bue.codigoUsuario   = bu.codigoUsuario;
        PegaUsuarioEmail();
        
        if(addUsu.equals("S")){
            bm.idEmpresa        = parametrosNS.be.IdEmpresa;
            bm.codigoGrupo      = parametrosNS.be.CodigoGrupo;
            bm.codigoEmpresa    = parametrosNS.be.CodigoEmpresa;
        }else{
            bm.idEmpresa        = bu.idEmpresa;
            bm.codigoGrupo      = bu.codigoGrupo;
            bm.codigoEmpresa    = bu.codigoEmpresa;
        }
        PegaModulos();
    }
    
    private static void PegaImagemUsuario(){
        sql = "select imagemUsuario from tb_usuarios where idUsuario = " + bu.idUsuario + ";";
        bu.imagemUsuario = parametrosNS.dao.ConsultaLogotipo(sql, "imagemUsuario");
    }
    
    private static void PegaUsuarioEmail(){
        sql = "select * from tb_usuarios_email where idEmpresa = " + bue.idEmpresa + " and codigoUsuario = " + bue.codigoUsuario + ";";
        dadosUsuarioEmail.clear();
        dadosUsuarioEmail = parametrosNS.dao.Consulta(sql);
        if(dadosUsuarioEmail.isEmpty()){
            return;
        }
        PegaDadosUsuarioEmail();
    }
    
    private static void PegaDadosUsuarioEmail(){
        for(int i = 0; i < dadosUsuarioEmail.size(); i++){
            if(dadosUsuarioEmail.get(i).get(0)  != null){bue.idUsuarioEmail       = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(0)));}
            if(dadosUsuarioEmail.get(i).get(1)  != null){bue.idEmpresa            = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(1)));}
            if(dadosUsuarioEmail.get(i).get(2)  != null){bue.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(2)));}
            if(dadosUsuarioEmail.get(i).get(3)  != null){bue.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(3)));}
            if(dadosUsuarioEmail.get(i).get(4)  != null){bue.codigoUsuario        = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(4)));}
            if(dadosUsuarioEmail.get(i).get(5)  != null){bue.servidorEmail        =                    String.valueOf(dadosUsuarioEmail.get(i).get(5));}
            if(dadosUsuarioEmail.get(i).get(6)  != null){bue.portaEmail           = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(6)));}
            if(dadosUsuarioEmail.get(i).get(7)  != null){bue.usuarioServidorEmail =                    String.valueOf(dadosUsuarioEmail.get(i).get(7));}
            if(dadosUsuarioEmail.get(i).get(8)  != null){bue.senhaServidorEmail   =                    String.valueOf(dadosUsuarioEmail.get(i).get(8));}
            if(dadosUsuarioEmail.get(i).get(9)  != null){bue.email                =                    String.valueOf(dadosUsuarioEmail.get(i).get(9));}
            if(dadosUsuarioEmail.get(i).get(10) != null){bue.autenticacaoSSL      = Integer.parseInt(  String.valueOf(dadosUsuarioEmail.get(i).get(10)));}
        }
    }
    
    public static void PegaModulos(){
        gsAlert = "N";
        sql = "select * from tb_modulos where codigoGrupo = " + bm.codigoGrupo + " and codigoEmpresa = " + bm.codigoEmpresa + " and usuarioModulo = " + parametrosNS.bu.codigoUsuario + ";";
        dadosModulos.clear();
        dadosModulos = parametrosNS.dao.Consulta(sql);
        if(dadosModulos.isEmpty()){
            PegaModulosPadroes();
            return;
        }
        SetaModulos();
    }
    
    private static void PegaModulosPadroes(){
        bm.codigoEmpresa = 0;
        sql = "select * from tb_modulos where codigoGrupo = " + bm.codigoGrupo + " and codigoEmpresa = " + bm.codigoEmpresa + " and usuarioModulo = " + parametrosNS.bu.codigoUsuario + ";";
        dadosModulos.clear();
        dadosModulos = parametrosNS.dao.Consulta(sql);
        if(dadosModulos.isEmpty()){
            gsAlert = "S";
            Mensagem = "Não existe Perfil criado para o usuário " +  bu.codigoUsuario + "!";
            new MostraMensagem(Mensagem);
            return;
        }
        SetaModulos();
    }
    
    private static void SetaModulos(){
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
    
}
