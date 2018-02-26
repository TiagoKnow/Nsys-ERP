package daoConexao;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * @author Tiago de Sá   16/03/2016 08:33
 * @author Paulo Rodrigo 16/03/2016 08:34
 */
public class fabricaConexaoAccess {
    
    public static Connection getConexao(){
            try{
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                return DriverManager.getConnection("jdbc:odbc:nomeBD");
            }
            catch(ClassNotFoundException e){
                JOptionPane.showMessageDialog(null, "Erro: " + e);
                return null;
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro na Fábrica de Conexão ACCESS: " + e);
                return null;
            }
        }
    
}
