package project.proyecto.backend;

import codeandbugs01.BaseDatos;
import java.util.LinkedList;
import java.util.List;
import project.baseDatos.ManejadorBaseDatos;
import project.caso.backend.ManejadorCaso;
import project.usuario.ManejadorUsuario;
import project.usuario.Usuario;

/**
 *
 * @author fabricio
 */
public class ManejadorProyecto {

    private BaseDatos DB = null;
    private ManejadorBaseDatos DBMS = null;

    public ManejadorProyecto(BaseDatos DB) {
        this.DB = DB;
        this.DBMS = new ManejadorBaseDatos(this.DB);
    }

    public Proyecto getProyectoByID(String ID) {
        String consulta = "SELECT * FROM PROYECTO WHERE ID = ?";
        return null;
    }

    public List getProyectos() {
        String consulta = "SELECT * FROM PROYECTO";
        return DBMS.getProyecto(consulta, "", 0);
    }

    public List getProyectoByDpiAdminAndStatus(String dpi) {
        String consulta = "SELECT * FROM PROYECTO WHERE DPI_ADMINISTRADOR = ? AND ESTADO = ?";
        return DBMS.getProyecto(consulta, dpi, 2);
    }

    public List getProyectoByDpiAdmin(String dpi) {
        String consulta = "SELECT * FROM PROYECTO WHERE DPI_ADMINISTRADOR = ?";
        return DBMS.getProyecto(consulta, dpi, 1);
    }

    public List getProyectoByStatus(int status) {
        String consulta = "SELECT * FROM PROYECTO WHERE ESTADO = ?";
        return DBMS.getProyecto(consulta, Integer.toString(status), 1);
    }

    public void setProyectoInDataBase(String nombrePry, String dpi) throws Exception {
        ManejadorUsuario mu = new ManejadorUsuario(this.DB);
        Usuario usr = (Usuario) mu.getUsuarioByDPI(dpi).get(0);
        if (nombrePry.isEmpty()) {
            throw new Exception("\"Nombre de Proyecto\" vacio, intentelo de nuevo");
        } else if (dpi.isEmpty()) {
            throw new Exception("\"DPI Administrador Asignado\" vacio, intentelo de nuevo");
        } else if (usr == null) {
            throw new Exception("El \"DPI\" del Administrador Asignado no existe, intentelo de nuevo");
        } else if (usr.getTipo() != 2) {
            throw new Exception("El \"Administrador\" asignado no es \"Administrador de Proyecto\", intentelo de nuevo");
        } else {
            String accion = "INSERT INTO PROYECTO(NOMBRE, DPI_Administrador) VALUES (?,?)";
            Proyecto pry = new Proyecto(0, nombrePry, Byte.parseByte("1"), Integer.parseInt(dpi));
            DBMS.setProyecto(accion, pry);
        }
    }

    public void updateProyecto(Proyecto pry, String nombre, String DPI) throws Exception {
        ManejadorUsuario mu = new ManejadorUsuario(this.DB);
        if (nombre.isEmpty()) {
            throw new Exception("\"Nombre\" vacio, intentelo de nuevo.");
        } else if (DPI.isEmpty()) {
            throw new Exception("\"DPI Administrador\" vacio, intentelo de nuevo.");
        } else {
            if (mu.getUsuarioByDPI(DPI) != null) {
                Usuario usr = (Usuario) mu.getUsuarioByDPI(DPI).get(0);
                if (usr.getTipo() != 2) {
                    throw new Exception("El \"DPI\" no pertenece a un usuario de tipo \"Administrador de Proyecto\".");
                } else {
                    String update = "UPDATE PROYECTO SET NOMBRE = ?, DPI_ADMINISTRADOR = ? WHERE ID = ?";
                    Proyecto pryFinal = new Proyecto(pry.getID(), nombre, new Byte("1"), Integer.parseInt(DPI));
                    DBMS.updateProyecto(update, pryFinal, 1);
                }
            } else {
                throw new Exception("El \"DPI\" ingresado no esta registrado en el sistema, intentelo de nuevo");
            }
        }
    }

    public void modifyStatusProyecto(Proyecto pry, String estado) {
        String accion = "UPDATE PROYECTO SET ESTADO = ? WHERE ID = ?";
        Proyecto pryFinal = new Proyecto(pry.getID(), pry.getNombre(), Byte.parseByte(estado), pry.getDPIAdministrador());
        DBMS.updateProyecto(accion, pryFinal, 2);
    }

    public void getProyectoByFinalizado() {
        List<Proyecto> listaProy = new LinkedList<>();
        ManejadorCaso mc = new ManejadorCaso(DB);
        Proyecto proyecto = null;
        int indiceMayor = 0;
        if (getProyectos() != null) {
            listaProy.addAll(getProyectos());
            if (listaProy.size() == 1) {
                proyecto = listaProy.get(0);
            } else {
                for (int i = 0; i < listaProy.size() - 1; i++) {
//                    indiceMayor 
//                        if (mc.getNumeroFinalizado(Integer.toString(listaProy.get(i).getID())) > mc.getNumeroFinalizado(Integer.toString(listaProy.get(i + 1).getID()))) {
//                            
//                        }
                }
            }
        }
    }

    public void getProyectoByCancelado() {

    }
}
