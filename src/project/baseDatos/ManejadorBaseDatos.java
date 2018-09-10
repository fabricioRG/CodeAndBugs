package project.baseDatos;

import codeandbugs01.BaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.LinkedList;
import project.caso.backend.TipoCaso;
import project.proyecto.backend.Proyecto;
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

    public List getUsuario(String datoUsuario, String consulta, int opcion) {
        List<Usuario> usuarios = new LinkedList<>();
        Usuario usr = null;
        try {
            declaracion = connection.createStatement();
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, datoUsuario);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int DPI = resultado.getInt("DPI");
                String nombre = resultado.getString("Nombre");
                String apellido = resultado.getString("Apellido");
                byte tipo = resultado.getByte("Tipo");
                String usuario = resultado.getString("Nombre_Usuario");
                String password = resultado.getString("Password");
                usr = new Usuario(DPI, nombre, apellido, usuario, password, tipo);
                usuarios.add(usr);
            }
            sentencia.close();
            if (usuarios.isEmpty()) {
                usuarios = null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return usuarios;
    }

    public void setUsuario(String accion, Usuario usr) {
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
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List getProyecto(String consulta, String datoProyecto, int opcion) {
        List<Proyecto> prys = new LinkedList<>();
        Proyecto pry = null;
        try {
            declaracion = connection.createStatement();
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, datoProyecto);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int ID = resultado.getInt("ID");
                String nombre = resultado.getString("Nombre");
                byte estado = resultado.getByte("Estado");
                int DPIAdministrador = resultado.getInt("DPI_Administrador");
                pry = new Proyecto(ID, nombre, estado, DPIAdministrador);
                prys.add(pry);
            }
            sentencia.close();
            if (prys.isEmpty()) {
                prys = null;
            }
        } catch (Exception e) {
            pry = null;
            e.printStackTrace(System.out);
        }
        return prys;
    }

    public void setProyecto(String accion, Proyecto pry) {
        try {
            declaracion = connection.createStatement();
            sentencia = connection.prepareStatement(accion);
            sentencia.setString(1, pry.getNombre());
            sentencia.setString(2, Integer.toString(pry.getDPIAdministrador()));
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List getTipoCaso(String consulta, String datoTipoCaso) {
        List<TipoCaso> tipoCaso = new LinkedList<>();
        TipoCaso tpcs = null;
        try {
            declaracion = connection.createStatement();
            sentencia = connection.prepareStatement(consulta);
            sentencia.setString(1, datoTipoCaso);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String nombre = resultado.getString("Nombre");
                int noPasos = resultado.getInt("No_Pasos");
                tpcs = new TipoCaso(nombre, noPasos);
                tipoCaso.add(tpcs);
            }
            if (tipoCaso.isEmpty()) {
                tipoCaso = null;
            }
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoCaso;
    }

    public void setTipoCaso(String accion, TipoCaso tc) {
        try {
            declaracion = connection.createStatement();
            sentencia = connection.prepareStatement(accion);
            sentencia.setString(1, tc.getNombre());
            sentencia.setInt(2, tc.getNumeroPasos());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProyecto(String update, Proyecto pry, int opcion) {
        try {
            declaracion = connection.createStatement();
            sentencia = connection.prepareStatement(update);
            if (opcion == 1) {
                sentencia.setString(1, pry.getNombre());
                sentencia.setInt(2, pry.getDPIAdministrador());
                sentencia.setInt(3, pry.getID());
            } else if(opcion == 2){
                sentencia.setByte(1, pry.getEstado());
                sentencia.setInt(2, pry.getID());
            }
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
