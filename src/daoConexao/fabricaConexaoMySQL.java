package daoConexao;
import BeansNS.BeanBancoDados;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class fabricaConexaoMySQL {    
    static String mensagem = "";
    
    public static Connection AbrirConexao(ArrayList dadosConexao){
        //Connection
        Connection con = null;
        
        //Beans
        BeanBancoDados    bbd   = new BeanBancoDados();
            
        try{
            bbd.servidor     = (String)dadosConexao.get(0);
            bbd.porta        = (int)   dadosConexao.get(1);
            bbd.usuario      = (String)dadosConexao.get(2);
            bbd.senha        = (String)dadosConexao.get(3);
            bbd.nomeBanco    = (String)dadosConexao.get(4);
            
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://" + bbd.servidor + ":" + bbd.porta + "/" + bbd.nomeBanco + "?autoReconnect=true" ,bbd.usuario, bbd.senha);
            
//            System.out.println("Connection MySQL: " + con);
            return con;
        }catch(Exception erro){
            con = null;
//            mensagem = "Impossível se conectar ao servidor " + bbd.servidor + " !\nEntre em contato com o administrador do sistema! " + erro;
//            mostraMensagem();
            return con;
        }
    }
    
    public static String fecharConexao(Connection con){
        if(con == null)return "OK";
        try{
            con.close();
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return "OK";
    }

    private static void mostraMensagem() {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
}