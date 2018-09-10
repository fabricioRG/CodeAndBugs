package project.usuario;

import codeandbugs01.BaseDatos;
import java.util.List;
import javax.swing.JOptionPane;
import project.baseDatos.ManejadorBaseDatos;

/**
 *
 * @author fabricio
 */
public class ManejadorUsuario {

    private ManejadorBaseDatos DBMS = null;
    private BaseDatos DB = null;
    static final String NO_VALIDO = "\t\tAccion no valida\n";
    
    public ManejadorUsuario(BaseDatos DB) {
        this.DB = DB;
        this.DBMS = new ManejadorBaseDatos(this.DB);
    }

    //Metodo que devuelve un Objeto Usuario, recibiendo como parametro el nombre de usuario
    public List getUsuarioByNombreUsuario(String nombreUsuario) {
        String consulta = "SELECT * FROM USUARIO WHERE Nombre_Usuario = ?";
        return this.DBMS.getUsuario(nombreUsuario, consulta, 1);
    }
    //Metodo que devuelve un Objeto Usuario, recibiendo como parametro el DPI del usuario
    public List getUsuarioByDPI(String DPIUsuario){
        String consulta = "SELECT * FROM USUARIO WHERE DPI = ?";
        return this.DBMS.getUsuario(DPIUsuario, consulta, 1);
    }

    //
    public void setUsuarioInDatabase(String dpi, String name, String lastName, String user, String pass, String type) throws Exception{
        if (name.isEmpty()){
            throw new Exception(NO_VALIDO + "\"Nombre\" vacio, intentelo de nuevo.");
        } else if (name.length() > 20){
            throw new Exception(NO_VALIDO + "El \"Nombre\" ha superado la cantidad maxima de caracteres (20), intentelo de nuevo.");
        } else if(lastName.isEmpty()){
            throw new Exception(NO_VALIDO + "\"Apellido\" vacio, intentelo de nuevo.");
        } else if(lastName.length() > 20){
            throw new Exception(NO_VALIDO + "El \"Apellido\" ha superado la cantidad maxima de caracteres(20), intentelo de nuevo.");
        } else if(dpi.isEmpty()){
            throw new Exception(NO_VALIDO + "Se ha ingresado un \"DPI\" vacio, intentelo de nuevo.");
        } else if(user.isEmpty()){
            throw new Exception(NO_VALIDO + "\"Nombre de Usuario\" vacio, intentelo de nuevo");
        } else if(user.length() > 10){
            throw new Exception(NO_VALIDO + "El \"Nombre de Usuario\" ha superado la cantidad maxima de caracteres (10), intentelo de nuevo.");
        } else if(pass.isEmpty()){
            throw new Exception(NO_VALIDO + "\"Contraseña\" vacia, intentelo de nuevo");
        } else if(pass.length() > 15){
            throw new Exception(NO_VALIDO + "La \"Contraseña\" ha superado la cantidad maxima de caracteres (15), intentelo de nuevo.");
        } else if(getUsuarioByDPI(dpi) != null){
            throw new Exception(NO_VALIDO + "El \"DPI\" que se ha ingresado ya ha sido registrado anteriormente, intentelo de nuevo ingresando un DPI diferente.");
        } else if(getUsuarioByNombreUsuario(user) != null){
            throw new Exception(NO_VALIDO + "El \"Nombre de usuario\" ya ha sido registrado anteriormente, intetelo de nuevo ingresando un usuario diferente.");
        } else {
            String accion = "INSERT INTO USUARIO(DPI, NOMBRE, APELLIDO, TIPO, NOMBRE_USUARIO, PASSWORD) VALUES (?,?,?,?,?,?)";
            Usuario usr = new Usuario(Integer.parseInt(dpi), name, lastName, user, pass, Byte.parseByte(Character.toString(type.charAt(0))));
            DBMS.setUsuario(accion, usr);
        }
    }
    
}
