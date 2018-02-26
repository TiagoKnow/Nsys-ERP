package SQL;

import Parametros.parametrosNS;
import java.sql.SQLException;
import org.sqlite.*;

/*
 @author Paulo e Tiago
 */
public class SQLSTATE {
    //String's
    String     sqlstate     = "";
    String     Mensagem     = "";
    MostraErro ME           = new MostraErro();
    String     SQLMensagem  = "";
    String     Mostra       = "";
    
    //int's
    int        sqlcode      = 0;
    
    //Telas
    
    public String SQLSTATE(SQLException erro, String SQLmensagem, String mostra){
        sqlstate    = erro.getSQLState();
        sqlcode     = erro.getErrorCode();
        Mensagem    = erro.getMessage();
        SQLMensagem = SQLmensagem;
        Mostra      = mostra;
        
        //System.out.println("SQLSTATE: " + SQLSTATE + "\nMensagem: " + Mensagem + "\nSQLMensagem: " + SQLMensagem);
        sqlstate = ME.MostraErro(sqlstate, sqlcode, Mensagem, SQLMensagem, Mostra, "sqlstate");
        return sqlstate;
    }
    
//    public String SQLite(SQLite erro, String SQLmensagem, String mostra){
//        SQLSTATE = String.valueOf(SQLiteErrorCode.valueOf(erro).code);
//        Mensagem = String.valueOf(SQLiteErrorCode.valueOf(erro).SQLITE_ERROR);
//        SQLMensagem = SQLmensagem;
//        Mostra = mostra;
//        
//        System.out.println("SQLSTATE: " + SQLSTATE + "\nMensagem: " + Mensagem + "\nSQLMensagem: " + SQLMensagem);
//        ME.MostraErro(SQLSTATE, Mensagem, SQLMensagem, Mostra, "SQLite");
//        return SQLSTATE;
//    }
}
