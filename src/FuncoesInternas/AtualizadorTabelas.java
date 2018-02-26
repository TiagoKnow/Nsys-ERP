package FuncoesInternas;

import Dao.DaoMySQL;
import daoConexao.fabricaConexaoMySQL;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * @author Tiago 05/10/2017 at 16:35
 */

//Lembrando que essa classe vai precisar fazer exatamente 
//um espelho do que ocorre na base de dados local

//Insert, update e delete

//Pensar numa lógica para comparar todas as conulas

//Se não houver conexão com o banco de dados online

//Encerrar e efetuar esse detalhe depois
public class AtualizadorTabelas {
    //Fábricas de conexão
    Connection con1 = null; // Local (Se houver)
    Connection con2 = null; // Base de dados online (NS3)
    
    //Operações DAO
    DaoMySQL d1; // opr1
    DaoMySQL d2; // opr2
    
    //Vetores - tabelas (Banco de dados)
    ArrayList            config           = new ArrayList();
    ArrayList<ArrayList> tabelas          = new ArrayList();
    ArrayList<ArrayList> estruturaTabelas = new ArrayList();
    
    //String
    String mensagem   = "";
    String nomeTabela = "";
    String sql        = "";
    
    //Configurações da base de dados online
    String servidor  = "mysql.ns3info.com.br";
    int    porta     = 3306;
    String usuario   = "ns3info";
    String senha     = "adm2322";
    String nomeBanco = "ns3info";
    
    public String Atualizar(){
        //Configurações do banco de dados ao vetor
        config.clear();        // ok - Limpar vetor
        config.add(servidor);  // ok - 1
        config.add(porta);     // ok - 2
        config.add(usuario);   // ok - 3
        config.add(senha);     // ok - 4
        config.add(nomeBanco); // ok - 5
        
        //Abrindo as conexões
        con1 = Parametros.parametrosNS.con; // Pegando a conexão o qual o sistema já está sendo executado
        con2 = fabricaConexaoMySQL.AbrirConexao(config);
        
        System.out.println("Saída do atualizador: con1 = " + con1);
        System.out.println("Saída do atualizador: con2 = " + con2);
        
        //sql
        
        return "";
    }
}
