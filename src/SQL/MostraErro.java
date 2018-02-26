package SQL;

import Parametros.parametrosNS;
import java.sql.Connection;
import javax.swing.JOptionPane;

/*
 @author Paulo e Tiago
 */
public class MostraErro {
    //Connection's
    Connection con;
    
    //String's
    String sqlstate     = "";
    String SQLMensagem  = "";
    String Mensagem     = "";
    String Mostra       = "";
    String TIPO         = "";
    
    //int's
    int    sqlcode     = 0;
    
    //Telas
    
    public String MostraErro(String SQL, int   SQLCODE, String mensagem, String SQLmensagem, String mostra, String tipo){
        sqlstate        = SQL;
        sqlcode         = SQLCODE;
        Mensagem        = mensagem;
        SQLMensagem     = SQLmensagem;
        Mostra          = mostra;
        TIPO            = tipo;
        
        if(TIPO.equalsIgnoreCase("sqlstate")){
            MostraSQLSTATE();
        }else{
            MostraSQLite();
        }
        return sqlstate;
    }
    
    public void MostraSQLSTATE(){
        if(sqlstate == null)                           {Mensagem = "Valor Nulo Indefinido\n"                                 + Mensagem + ".\n"   + SQLMensagem;}
        if(sqlstate.equals("42000")                   ){Mensagem = "Erro de síntaxe da variavel sql\n"                       + Mensagem + ".\n"   + SQLMensagem;}
        if(sqlstate.equals("22001")                   ){Mensagem = "Limite maximo do campo excedido\n"                                            + SQLMensagem + ".";}
        if(sqlstate.equals("21S01")                   ){Mensagem = "Quantidade de colunas inválida no Insert\n"                                   + SQLMensagem + ".";}
        if(sqlstate.equals("01000")                   ){Mensagem = "Variavel do sistema imconpatível com a do SQL";}
        if(sqlstate.equals("S0022")                   ){Mensagem = "Coluna do banco de dados desconhecida\n"                 + Mensagem + ".\n"   + SQLMensagem;}
        if(sqlstate.equals("S1009")                   ){Mensagem = "Parametros de inclusão inválidos\n"                      + Mensagem + ".\n"   + SQLMensagem;}
        if(sqlstate.equals("42S22")                   ){Mensagem = "Coluna do Banco de Dados inválida\n"                     + Mensagem + ".\n"   + SQLMensagem;}
        if(sqlstate.equals("42S02") && sqlcode == 1146){Mensagem = "Tabela referenciada não existe no Banco de Dados\n"      + Mensagem + ".\n"/*   + SQLMensagem*/;}
        if(sqlstate.equals("42S02") && sqlcode == 1051){Mensagem = "Tabela referenciada não existe no Banco de Dados\n"      + SQLMensagem + ".\n" + Mensagem;Mostra = "N";}
        if(sqlstate.equals("42S01") && sqlcode == 1050){Mensagem = "Tabela referenciada já  existe no Banco de Dados\n"      + Mensagem + ".\n"   + SQLMensagem;}
        if(sqlstate.equals("HY000")                   ){Mensagem = "Coluna não possui um valor padrão\n"                     + Mensagem + ".\n"   + SQLMensagem;}
        if(sqlstate.equals("07001")                   ){Mensagem = "\n" + Mensagem + ".\n" + SQLMensagem;}
        if(sqlstate.equals("22003")                   ){Mensagem = "\n" + Mensagem + ".\n" + SQLMensagem;}
        if(sqlstate.equals("08S01")                   ){Mensagem = "Houve perda de conexão com o link de rede\nEntre em contato com o administrador do sistema";}
        if(sqlstate.equals("08003")                   ){Mensagem = "Firewall do banco de dados com problema\nEntre em contato com o administrador do sistema";}
        
        if(sqlstate.equals("08S01") || sqlstate.equals("08003")){
            parametrosNS.RecarregaConexao();
            if(parametrosNS.con != null)
                return;
        }
        
        VerificaMostra();
    }
    
    private void VerificaMostra(){
        if(Mostra.equals("N"))
            return;
        MostraErroSQLSTATE();
    }
    
    public void MostraErroSQLSTATE(){
        JOptionPane.showMessageDialog(null ,"SQLSTATE [" + sqlstate + "]\nSQLCODE  [" + sqlcode + "]\n" + Mensagem);
    }
    
    public void MostraSQLite(){
        if(sqlstate == null)   {Mensagem = "Valor Nulo Indefinido";MostraErroSQLite();return;}
        if(sqlstate.equals("")){Mensagem = "Valor Nulo Indefinido";}
        
        if(Mostra.equals("N"))
            return;
        MostraErroSQLite();
    }
    
    public void MostraErroSQLite(){
        JOptionPane.showMessageDialog(null ,"SQLite [" + sqlstate + "]: " + SQLMensagem);
    }
}
