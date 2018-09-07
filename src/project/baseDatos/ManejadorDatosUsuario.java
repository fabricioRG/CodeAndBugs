package project.baseDatos;

import java.util.List;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.usuario.Usuario;

/**
 *
 * @author fabricio
 */
public class ManejadorDatosUsuario {

    private static final String urlBasica = "jdbc:mysql://localhost/PROYECTO1";
    private Connection connection = null;
    private Statement declaracion = null;
    private PreparedStatement sentencia = null;

    public ManejadorDatosUsuario() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String usuario = "root";
            String password = "ex=d/dx=ex";
            Properties propiedades = new Properties();
            propiedades.setProperty("user", usuario);
            propiedades.setProperty("password", password);
            connection = DriverManager.getConnection(urlBasica, propiedades);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Usuario getUsuario(String datoUsuario, String consulta) {
        Usuario usr = null;
        try {
            declaracion = connection.createStatement();
            sentencia = connection.prepareStatement(consulta);
            sentencia.setString(1, datoUsuario);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                int DPI = resultado.getInt("DPI");
                String nombre = resultado.getString("Nombre");
                byte tipo = resultado.getByte("Tipo");
                String usuario = resultado.getString("Nombre_Usuario");
                String password = resultado.getString("Password");
                usr = new Usuario(DPI, nombre, usuario, password, tipo);
            }
        } catch (Exception e) {
            usr = null;
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
        return usr;
    }

}
