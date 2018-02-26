package SQL;

import Parametros.parametrosNS;
import java.util.ArrayList;
import java.sql.*;
import java.text.*;
import java.util.*;
/*
 @author Paulo  e Tiago
 */
public class Commit {
    //Connection's
    Connection con;
    
    //String's
    String sql                  = "";
    
    //Especiais
    PreparedStatement   stmt;
    ResultSet           rs;
    
    //Telas
    SQLSTATE SQL = new SQLSTATE();
    public Commit(Connection con1){
        con = con1;
    }
    
    public void ExecuteCommit(){
        sql = "Commit;";
        try{
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
        }catch(SQLException erro){
            SQL.SQLSTATE(erro, sql, "S");
        }
    }
}