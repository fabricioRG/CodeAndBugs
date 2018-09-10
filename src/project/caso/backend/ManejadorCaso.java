package project.caso.backend;

import codeandbugs01.BaseDatos;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import project.baseDatos.ManejadorBaseDatos;
import project.usuario.Usuario;

/**
 *
 * @author fabricio
 */
public class ManejadorCaso {

    private BaseDatos DB = null;
    private ManejadorBaseDatos DBMS = null;
    private SimpleDateFormat fechaFormat = null; 

    public ManejadorCaso(BaseDatos DB) {
        this.DB = DB;
        this.DBMS = new ManejadorBaseDatos(this.DB);
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public List getTipoCasoByNombre(String nombre) {
        String consulta = "SELECT * FROM TIPO_CASO WHERE NOMBRE = ?";
        return DBMS.getTipoCaso(consulta, nombre, 1);
    }
    
    public List getTipoCaso(){
        String consulta = "SELECT * FROM TIPO_CASO";
        return DBMS.getTipoCaso(consulta, null, 0);
    }

    public TipoCaso getTipoCasoByCasoId(String idCaso){
        String consulta = "SELECT TIPO_CASO.* FROM TIPO_CASO, CASO WHERE CASO.ID = ? AND CASO.TIPO = TIPO_CASO.NOMBRE;";
        TipoCaso Tipocaso = (TipoCaso) DBMS.getTipoCaso(consulta, idCaso, 1).get(0);
        return Tipocaso;
    }
    
    public void setTipoCasoInDataBase(String nombre, String noPasos) throws Exception {
        String pasos = noPasos;
        if (nombre.isEmpty()) {
            throw new Exception("\"Nombre del Tipo Caso\" vacio, intentelo de nuevo");
        } else if (noPasos.isEmpty()) {
            throw new Exception("\"Numero de Pasos\" vacio, intentelo de nuevo");
        } else if (nombre.length() > 20) {
            throw new Exception("\"Nombre de Tipo de Caso\" no valido, numero de caracteres maximo superado, intentelo de nuevo.");
        } else if (getTipoCasoByNombre(nombre) != null) {
            throw new Exception("\"Nombre de Tipo de Caso\" ya existente, intentelo de nuevo ingresando uno diferente.");
        } else {
            if (noPasos.contains("-")) {
                pasos = pasos.replaceAll("-", "");
            }
            String accion = "INSERT INTO TIPO_CASO (Nombre, No_Pasos) VALUES (?,?)";
            TipoCaso tc = new TipoCaso(nombre, Integer.parseInt(noPasos));
            DBMS.setTipoCaso(accion, tc);
        }
    }
    
    public void setCaso(String fechaIni, String fechaLim, String tipo, String IdProy) throws Exception{
        if(fechaIni.replaceAll("-", "").replaceAll(" ", "").isEmpty()){
            throw new Exception("\"Fecha de Inicio\" vacia, intetelo de nuevo");
        } else if(fechaLim.replaceAll("-", "").replaceAll(" ", "").isEmpty()){
            throw new Exception("\"Fecha Limite\" vacia, intetelo de nuevo");
        } else if(tipo.replaceAll(" ", "").isEmpty()){
            throw new Exception("No hay \"Tipo de Caso\" disponibles, intetelo de nuevo");
        }  else if(IdProy.replaceAll(" ", "").isEmpty()){
            throw new Exception("No hay \"Proyectos\" disponibles, intentelo de nuevo");
        }
        String accion = "INSERT INTO CASO(FECHA_INICIO, FECHA_LIMITE, TIPO, ID_PROYECTO) VALUES (?, ?, ?, ?)";
        Date fechaInicio = fechaFormat.parse(fechaIni);
        Date fechaLimite = fechaFormat.parse(fechaLim);
        Caso caso = new Caso(0, fechaInicio, fechaLimite, null, 0, null, tipo, Integer.parseInt(IdProy));
        DBMS.setCaso(accion, caso);
    }
    
    public List getCasoByStatusAndDpiAdmin(Usuario usr){
        String consulta = "SELECT CASO.* FROM PROYECTO, CASO WHERE PROYECTO.DPI_ADMINISTRADOR = ? AND PROYECTO.ID = CASO.ID_PROYECTO AND PROYECTO.ESTADO = ?";
        return DBMS.getCaso(consulta, Integer.toString(usr.getDPI()), 1);
    }
    
    public List getCasoById(String id){
        String consulta = "SELECT * FROM CASO WHERE ID = ?";
        return DBMS.getCaso(consulta, id, 1);
    }
    
}
