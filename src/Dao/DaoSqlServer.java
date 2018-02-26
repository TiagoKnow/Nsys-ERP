package Dao;

import Beans.*;
import SQL.*;
import java.sql.*;
import java.util.ArrayList;
import Parametros.parametrosNS;
/*
 @author Tiago e Paulo
 */
public class DaoSqlServer {
    //Connection
    Connection con;
    
    //String
    public String sqlstate      = "00000";
    String Mensagem             = "";
    String sql                  = "";
    String NomeColuna           = "";
    
    //int
    int    count                = 0;
    int    total                = 0;
    int    qtdColuna            = 0;
    int    i                    = 0;
    
    //Outros
    Commit Cmt;
    Rollback Rbk;
    SQLSTATE SQL = new SQLSTATE();
    
    //Vetores
    ArrayList<ArrayList>    retornoAcossiativo  = new ArrayList<ArrayList>();
    ArrayList<String>       linha               = new ArrayList<String>();
    ArrayList               retorno             = new ArrayList();
    
    //Beans
    BeanContasPagar                     bcp;
    BeanManutencoes                     bmanut;
    
    //Operações de BD
    Statement           stmt;
    PreparedStatement   pstmt;
    ResultSet           rs;
    ResultSetMetaData   rsmd;
    
    //Telas
    
    public DaoSqlServer(Connection con1){
        con = con1;
        
        Cmt = new Commit(con);
        Rbk = new Rollback(con);
    }
    
    public ArrayList Consulta(String sql1){
        sql = sql1;
        qtdColuna = 0;
        retornoAcossiativo = new ArrayList<ArrayList>();
        try{
            pstmt = con.prepareStatement(sql);
            rs    = pstmt.executeQuery();
            rsmd  = rs.getMetaData();  
            
            qtdColuna = rsmd.getColumnCount();
            while(rs.next()){
                linha = new ArrayList<String>();
                for(int i = 1; i <= qtdColuna; i++)
                    linha.add(rs.getString(i));
                retornoAcossiativo.add(linha);
            }
        }catch(SQLException erro){
            sqlstate = SQL.SQLSTATE(erro, sql, "S");
            retornoAcossiativo = new ArrayList();
        }
        return retornoAcossiativo;
    }
    
    public byte[] ConsultaLogotipo(String sql1, String nomeColuna){
        sql = sql1;
        byte[] Logotipo = null;
        try{
            pstmt = con.prepareStatement(sql);
            rs    = pstmt.executeQuery();
            if(rs.next())
                Logotipo = (rs.getBytes(nomeColuna));
        }catch(SQLException erro){
            sqlstate = SQL.SQLSTATE(erro, sql, "S");
            Logotipo = null;
        }
        return Logotipo;
    }
    
    ////////////INCLUIR
    public String incluirRegistro(String sql1){
        sqlstate = "00000";
        sql = sql1;
        try{
            pstmt = con.prepareStatement(sql);
            if(pstmt.executeUpdate() > 0){
                Cmt.ExecuteCommit();
            }else{
                Rbk.ExecuteROLLBACK();
                sqlstate = "02000";
            }
        }catch(SQLException erro){
            Rbk.ExecuteROLLBACK();
            sqlstate = SQL.SQLSTATE(erro, sql, "S");
        }
        return sqlstate;
    }
    
    public String atualizarImagens(String sql1, byte[] imagem){
        sqlstate = "00000";
        sql = sql1;
        try{
            pstmt = con.prepareStatement(sql);
            pstmt.setBytes(1, imagem);
            pstmt.execute();
            Cmt.ExecuteCommit();
            
            pstmt.close();
        }catch(SQLException erro){
            Rbk.ExecuteROLLBACK();
            sqlstate = SQL.SQLSTATE(erro, sql, "S");
        }
        return sqlstate;
    }
    
    ////////////alterarRegistro
    public String AlterarRegistroOuConsultaSeTabelaExiste(String sql1, String Mostra){
        sqlstate = "00000";
        sql = sql1;
        try{
            pstmt = con.prepareStatement(sql);
            pstmt.execute();
            Cmt.ExecuteCommit();
            
            pstmt.close();
        }catch(SQLException erro){
            Rbk.ExecuteROLLBACK();
            sqlstate = SQL.SQLSTATE(erro, sql, Mostra);
        }
        return sqlstate;
    }
    
    /////////Excluir Registro
    public String ExcluirRegistro(String sql1){
        sql = sql1;
        sqlstate = "00000";
        try{
            pstmt = con.prepareStatement(sql);
            pstmt.execute();
            Cmt.ExecuteCommit();
            
            pstmt.close();
        }catch(SQLException erro){
            Rbk.ExecuteROLLBACK();
            sqlstate = SQL.SQLSTATE(erro, sql, "S");
        }
        return sqlstate;
    }
    
    public int ConsultaAutoIncremento(String NomeTabela){
        int retorno = 0;
        sql = "show table status like '" + NomeTabela + "'";
        try{
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
        
            if(rs.next()){
                retorno = rs.getInt("Auto_increment");
            }
            rs.close();
            pstmt.close();
            return retorno;
        }catch(SQLException erro){
            Rbk.ExecuteROLLBACK();
            sqlstate = SQL.SQLSTATE(erro, sql, "S");
            return 0;
        }
    }
    
    public ArrayList ConsultaManutencoes(String sql1){
        sql = sql1;
        retorno = new ArrayList();
        sqlstate = "00000";
        try{
            pstmt = con.prepareStatement(sql);
            rs    = pstmt.executeQuery();
            
            while(rs.next()){
                bmanut = new BeanManutencoes();
                bmanut.codigoManutencao     = rs.getInt   ("codigoManutencao");
                bmanut.descricaoManutencao  = rs.getString("descricaoManutencao");
                bmanut.valorManutencao      = rs.getDouble("valorManutencao");
                retorno.add(bmanut);
            }
        }catch(SQLException erro){
            sqlstate = SQL.SQLSTATE(erro, sql, "S");
            retorno = new ArrayList();
        }
        return retorno;
    }
    
    public ArrayList ConsultaContasAPagar(String sql1){
        sql = sql1;
        retorno = new ArrayList();
        sqlstate = "00000";
        try{
            pstmt = con.prepareStatement(sql);
            rs    = pstmt.executeQuery();
            
            while(rs.next()){
                bcp = new BeanContasPagar();
                bcp.codigoContaPagar = rs.getInt    ("codigoContaPagar");
                bcp.codigoFornecedor = rs.getInt    ("codigoFornecedor");
                bcp.codigoDespesa    = rs.getInt    ("codigoDespesa");
                bcp.codigoUsuario    = rs.getInt    ("codigoUsuario");
                bcp.dataCadastro     = rs.getString ("dataCadastro");
                bcp.descricaoConta   = rs.getString ("descricaoConta");
                bcp.codigoDeBarras   = rs.getString ("codigoDeBarras");
                bcp.dataVencimento   = rs.getString ("dataVencimento");
                bcp.valorDevido      = rs.getDouble ("valorDevido");
                bcp.dataPagamento    = rs.getString ("dataPagamento");
                bcp.valorPago        = rs.getDouble ("valorPago");
                bcp.observacoes      = rs.getString ("observacoes");
                bcp.statusConta      = rs.getInt    ("statusConta");
                
                retorno.add(bcp);
            }
        }catch(SQLException erro){                
            sqlstate = SQL.SQLSTATE(erro, sql, "S");
            retorno = new ArrayList();
        }
        return retorno;
    }
    
    public ArrayList ConsultaNumeros(String sql1, String nomeColuna){
        sql         = sql1;
        NomeColuna  = nomeColuna;
        retorno     = new ArrayList();
        sqlstate    = "00000";
        try{
            pstmt = con.prepareStatement(sql);
            rs    = pstmt.executeQuery();
            
            while(rs.next())
                retorno.add(rs.getInt(NomeColuna));
            return retorno;
        }catch(SQLException erro){                
            sqlstate = SQL.SQLSTATE(erro, sql, "S");
            retorno = new ArrayList();
        }
        return retorno;
    }
    
}
