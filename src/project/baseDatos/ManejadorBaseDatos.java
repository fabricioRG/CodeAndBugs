package project.baseDatos;

import codeandbugs01.BaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import project.usuario.Usuario;

/**
 *
 * @author fabricio
 */
public class ManejadorBaseDatos {

    private Connection connection = null;
    private Statement declaracion = null;
    private PreparedStatement sentencia = null;
    private BaseDatos DB = null;

    public ManejadorBaseDatos(BaseDatos DB) {
        this.DB = DB;
        connection = DB.getConection();
        declaracion = DB.getStatement();
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
                String apellido = resultado.getString("Apellido");
                byte tipo = resultado.getByte("Tipo");
                String usuario = resultado.getString("Nombre_Usuario");
                String password = resultado.getString("Password");
                usr = new Usuario(DPI, nombre, apellido, usuario, password, tipo);
            }
        } catch (Exception e) {
            usr = null;
            e.printStackTrace(System.out);
        }
        return usr;
    }
    
    public void setUsuario(String accion, Usuario usr){
        try {
            declaracion = connection.createStatement();
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, usr.getDPI());
            sentencia.setString(2, usr.getNombre());
            sentencia.setString(3, usr.getApellido());
            sentencia.setByte(4, usr.getTipo());
            sentencia.setString(5, usr.getUsuario());
            sentencia.setString(6, usr.getPassword());
            sentencia.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
