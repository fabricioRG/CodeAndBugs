package project.caso.backend;

import codeandbugs01.BaseDatos;
import java.util.List;
import project.baseDatos.ManejadorBaseDatos;

/**
 *
 * @author fabricio
 */
public class ManejadorCaso {

    private BaseDatos DB = null;
    private ManejadorBaseDatos DBMS = null;

    public ManejadorCaso(BaseDatos DB) {
        this.DB = DB;
        this.DBMS = new ManejadorBaseDatos(this.DB);
    }

    public List getTipoCasoByNombre(String nombre) {
        String consulta = "SELECT * FROM TIPO_CASO WHERE NOMBRE = ?";
        return DBMS.getTipoCaso(consulta, nombre);
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

}
