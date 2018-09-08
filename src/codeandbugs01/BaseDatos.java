package codeandbugs01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabricio
 */
public class BaseDatos {
    
    private static final String urlBasica = "jdbc:mysql://localhost/PROYECTO1";
    private Connection connection = null;
    private Statement declaracion = null;

    public BaseDatos() {
    }
 
    public void initConection(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String usuario = "root";
            String password = "ex=d/dx=ex";
            Properties propiedades = new Properties();
            propiedades.setProperty("user", usuario);
            propiedades.setProperty("password", password);
            connection = DriverManager.getConnection(urlBasica, propiedades);
            declaracion = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Statement getStatement(){
        return this.declaracion;
    }
    
    public Connection getConection(){
        return this.connection;
    }
    
    public void closeConection(){
        if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
}
