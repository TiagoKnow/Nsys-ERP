package daoConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;


/**
 * @author Tiago
 */
public class fabricaConexaoSQLITE {
    String Mensagem = "";
    
    public static Connection abrirConexao(String nomeBanco){
        //Connection's
        Connection con = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + nomeBanco + ".db");
            //System.out.println("Conexão SQLite: " + con);
        }catch(Exception erro) {
            System.err.println( erro.getClass().getName() + ": " + erro.getMessage() );
            System.exit(0);
        }
        return con;
    }
    
}
