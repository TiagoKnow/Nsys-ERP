package Dao;

import SQL.SQLSTATE;
import Beans.beanTabelas;
import Beans.beanColunas;
import Parametros.parametrosNS;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Tiago e P 10/03/2016 17:55
 */
public class DaoTabelas {
    //Connection's
    Connection con;
    
    //String's
    String sql          = "";
    String NomeBanco    = "";
    
    //Outros
    PreparedStatement stmt;
    ResultSet rs;
    SQLSTATE SQL        = new SQLSTATE();
    
    //ArrayList's
    ArrayList Colunas      = new ArrayList();
    ArrayList Tabelas      = new ArrayList();
    ArrayList DadosTabela  = new ArrayList();
    //ArrayList Linha        = new ArrayList<ArrayList>();
    
    //ArrayList
    ArrayList            Matriz      = new ArrayList<Object>();
    ArrayList            Linha;
    
    //int's
    int   QTDColunas = 0;
    
    //Bean's
    beanTabelas    btab;
    beanColunas    bcol;
    
    //Telas
    
    public DaoTabelas(Connection con1){
        con = con1;
    }
    
    public ArrayList ConsultaPropriedadesTabela(String sql1){
        sql = sql1;
        DadosTabela.clear();
        try{
            stmt = con.prepareStatement(sql);
            rs   = stmt.executeQuery();
            
            while(rs.next()){
                btab = new beanTabelas();
                btab.TABLE_SCHEMA   = rs.getString("TABLE_SCHEMA");
                btab.TABLE_NAME     = rs.getString("TABLE_NAME");
                btab.TABLE_TYPE     = rs.getString("TABLE_TYPE");
                btab.TABLE_ROWS     = rs.getInt   ("TABLE_ROWS");
                btab.DATA_LENGTH    = rs.getInt   ("DATA_LENGTH");
                btab.CREATE_TIME    = rs.getString("CREATE_TIME");
                btab.TABLE_COMMENT  = rs.getString("TABLE_COMMENT");
                DadosTabela.add(btab);
            }
            return DadosTabela;
        }catch(SQLException erro){
            SQL.SQLSTATE(erro, sql, "S");
            DadosTabela.clear();
            return DadosTabela;
        }
    }
    
    public ArrayList ConsultaTabelas(String nomebanco){
        NomeBanco = nomebanco;
        sql = "SHOW TABLES FROM " + NomeBanco + ";";
        Tabelas.clear();
        try{
            stmt = con.prepareStatement(sql);
            rs   = stmt.executeQuery();
            
            while(rs.next()){
                Tabelas.add(rs.getString("Tables_in_" + NomeBanco));
            }
            return Tabelas;
        }catch(SQLException erro){
            SQL.SQLSTATE(erro, sql, "S");
            Tabelas.clear();
            return Tabelas;
        }
    }
    
    public ArrayList buscarColunas(String sql1){
        sql = sql1;
        Colunas.clear();
        try{
            stmt = con.prepareStatement(sql1);
            rs   = stmt.executeQuery();
            
            while(rs.next()){
                bcol = new beanColunas();
                bcol.Field      = rs.getString("Field");
                bcol.Type       = rs.getString("Type");
                bcol.Null       = rs.getString("Null");
                bcol.Key        = rs.getString("Key");
                bcol.Default    = rs.getString("Default");
                bcol.Extra      = rs.getString("Extra");
                Colunas.add(bcol);
            }
            return Colunas;
        }catch(SQLException erro){
            SQL.SQLSTATE(erro, sql, "S");
            Colunas.clear();
            return Colunas;
        }
    }
    
    public ArrayList<ArrayList> ConsultaValoresTabela(String sql1, ArrayList NOMEDASColunas){
        sql = sql1;
        try{
            stmt = con.prepareStatement(sql);
            rs   = stmt.executeQuery();
            
            QTDColunas = NOMEDASColunas.size();
            Matriz.clear();
            while(rs.next()){
                Linha = new ArrayList<String>();
                for (int i = 0; i < QTDColunas; i++){
                    Linha.add (rs.getString(i + 1));
                }
                //System.out.println(Linha);
                Matriz.add(Linha);
            }
            //System.out.println(Matriz);
            return Matriz;
        }catch(SQLException erro){
            SQL.SQLSTATE(erro, sql, "S");
            Matriz.clear();
            return Matriz;
        }
    }
    
}

