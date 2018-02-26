package TelasDeConfiguracoes;

import BeansNS.BeanBancoDados;
import BeansNS.BeanEmpresas;
import BeansNS.BeanGrupoEmpresa;
import BeansNS.BeanModulosAcesso;
import BeansNS.BeanNsComputadores;
import FuncoesInternas.MostraMensagem;
import SQL.*;
import java.sql.*;
import java.util.*;
import org.sqlite.SQLiteErrorCode;
import java.sql.Statement;
import org.sqlite.SQLite;

/*
 @author Tiago e Paulo
 */
public class daoSQLITE {
    //Connection's
    Connection ConSQLite;
    
    //String
    String sql              = "";
    String Mensagem         = "";
    String sqlstate         = "00000";
    
    //int's
    int    qtdColuna        = 0;
    
    //Outros
    Statement           stmt;
    PreparedStatement   pstmt;
    ResultSet           rs;
    ResultSetMetaData   rsmd;
    
    //ArrayList's
    ArrayList<ArrayList>    retornoAcossiativo  = new ArrayList();
    ArrayList<String>       linha               = new ArrayList();
    
    //Telas
    SQLSTATE SQL = new SQLSTATE();
    
    //Bean's
    BeanBancoDados                  bbd;
    BeanNsComputadores              bnscomp;
    
    public daoSQLITE(){
        sqlstate = "00000";
        try{
            Class.forName("org.sqlite.JDBC");
            ConSQLite = DriverManager.getConnection("jdbc:sqlite:NSys.db");
            ConSQLite.setAutoCommit(false);
        }catch(ClassNotFoundException erro){
            new MostraMensagem(erro.getClass().getName() + ": " + erro.getMessage());
        }catch(SQLException erro){
            
        }
    }
    
    public String IncluirRegistro(String sql1){
        sql = sql1;
        sqlstate = "00000";
        try{
            stmt = ConSQLite.createStatement();
            stmt.executeUpdate(sql);
            ConSQLite.commit();
            
            stmt.close();
        }catch(SQLException erro){
            Mensagem = "Erro ao Incluir Registro: " + erro.getMessage();
            new MostraMensagem(Mensagem);
            sqlstate = "99999";
        }
        return sqlstate;
    }
    
    public String AlterarRegistro(String sql1){
        sql = sql1;
        try{
            stmt = ConSQLite.createStatement();
            stmt.execute(sql);
            ConSQLite.commit();
            
            stmt.close();
        }catch(SQLException erro){
            Mensagem = "Erro ao Alterar Registro: " + erro.getMessage();
            new MostraMensagem(Mensagem);
            sqlstate = "99999";
        }
        return sqlstate;
    }
    
    public ArrayList Consulta(String sql1){
        sql = sql1;
        retornoAcossiativo = new ArrayList<ArrayList>();
        try{
            stmt  = ConSQLite.createStatement();
            rs    = stmt.executeQuery(sql);
            rsmd  = rs.getMetaData();  
            
            qtdColuna = rsmd.getColumnCount();
            while(rs.next()){
                linha = new ArrayList<String>();
                for(int i = 1; i <= qtdColuna; i++)
                    linha.add(rs.getString(i));
                retornoAcossiativo.add( linha );
            }
            rs.close();
            stmt.close();
            ConSQLite.close();
        }catch(SQLException erro){
            retornoAcossiativo = new ArrayList<ArrayList>();
        }
        return retornoAcossiativo;
    }
    
    public String CriaTabela(String sql1){
        sql = sql1;
        sqlstate = "00000";
        try{
            stmt = ConSQLite.createStatement();
            stmt.executeUpdate(sql);
            ConSQLite.commit();
            
            stmt.close();
            ConSQLite.close();
            return sqlstate;
        }catch(SQLException erro){
            Mensagem = "Erro ao Criar Tabela: " + erro.getMessage();
            new MostraMensagem(Mensagem);
            return sqlstate;
        }
    }
    
}
    

