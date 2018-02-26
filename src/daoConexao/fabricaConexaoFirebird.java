package daoConexao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class fabricaConexaoFirebird {

    private String host;
    private String user;
    private String pass;
    private String database;
   
    public Connection c;
   
    /**
     * Construtor da classe
     *
     * @param host Host em que se deseja conectar
     * @param database Nome do database em que se deseja conectar
     * @param user Nome do usuário
     * @param pass Senha do usuário
     */
    public fabricaConexaoFirebird ( String host, String database, String user, String pass ) {
        this.pass = pass;
        this.user = user;
        this.host = host;
        this.database = database;
    }
   
    /**
     * Método que estabelece a conexão com o banco de dados
     *
     * @return True se conseguir conectar, falso em caso contrário.
     */
    public boolean connect() {
        boolean isConnected = false;
        
        String url;
        String portNumber = "3050";
        String userName   = this.user;
        String passName   = this.pass;
        url = "jdbc:firebirdsql:"+ this.host+"/" +portNumber + ":" +this.database;
        
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();
            this.c = DriverManager.getConnection(url,userName, passName);
            isConnected = true;
        } catch( SQLException e ) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( InstantiationException e ) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( IllegalAccessException e ) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            isConnected = false;
        }
       
        return isConnected;
    }
   
    /**
     * Método que estabelece a desconexão com o banco de dados
     *
     * @return True se conseguir desconectar, falso em caso contrário.
     */
    public boolean disconnect() {
        boolean isConnected = false;
       
        String url;
        String portNumber = "3050";
        String userName   = this.user;
        String passName   = this.pass;
        url = "jdbc:firebirdsql:"+ this.host+"/" +portNumber + ":" +this.database;
             
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();
            this.c = DriverManager.getConnection(url,userName, passName);
            this.c.close();
            isConnected = true;
        } catch( SQLException e ) {
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( ClassNotFoundException e ) {
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( InstantiationException e ) {
            System.out.println(e.getMessage());
            isConnected = false;
        } catch ( IllegalAccessException e ) {
            System.out.println(e.getMessage());
            isConnected = false;
        }
       
        return isConnected;
    }
}