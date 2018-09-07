package project.baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabricio
 */
public class ManejadorBaseDatos {

    private static final String urlBasica = "jdbc:mysql://localhost/PROYECTO1";
    Connection connection = null;
    Statement declaracion = null;
    
    public ManejadorBaseDatos() {
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

    public void showUsuario() {
        try {

            ResultSet resultado = declaracion.executeQuery("SELECT DPI, Nombre FROM USUARIO;");

            int numeroFila = 1;
            System.out.println("Datos:");
            while (resultado.next()) {
                System.out.println("Fila " + numeroFila + " - " + "DPI: " + resultado.getString("DPI") + " | Nombre: " + resultado.getString("Nombre"));
                numeroFila++;
            }

        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace(System.out);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManejadorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}
