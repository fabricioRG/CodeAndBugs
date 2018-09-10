package project.etapa.backend;

import codeandbugs01.BaseDatos;
import java.util.List;
import project.baseDatos.ManejadorBaseDatos;
import project.usuario.Usuario;

/**
 *
 * @author fabricio
 */
public class ManejadorEtapa {

    private BaseDatos DB = null;
    private ManejadorBaseDatos DBMS = null;
    
    public ManejadorEtapa(BaseDatos DB) {
        this.DB = DB;
        this.DBMS = new ManejadorBaseDatos(this.DB);
    }
    
    public List getEtapaByCasoAndPaso(String NoPaso, String idCaso){
        String consulta = "SELECT * FROM ETAPA WHERE NO_PASO = ? AND ID_CASO = ?";
        Etapa etapa = new Etapa(Integer.parseInt(NoPaso), Integer.parseInt(idCaso), null, 0, new Byte("0"), 0);
        return DBMS.getEtapa(consulta, etapa, 1);
    }
    
    public List getEtapaByDpiDesarrNull(Usuario usr){
        String consulta = "SELECT ETAPA.* FROM ETAPA, CASO, PROYECTO WHERE ETAPA.DPI_DESARROLLADOR IS NULL AND CASO.ID_PROYECTO = PROYECTO.ID AND "
                + "PROYECTO.DPI_ADMINISTRADOR = ? AND ETAPA.ID_CASO = CASO.ID";
        Etapa etapa = new Etapa(0, 0, null, 0, new Byte("0"), usr.getDPI());
        return DBMS.getEtapa(consulta, etapa, 2);
    }
    
    public void setEtapaNoPasoIdCaso(int etapas, String idCaso){
        String accion = "INSERT INTO ETAPA(NO_PASO, ID_CASO) VALUES (?,?)";
        int IDCaso = Integer.parseInt(idCaso);
        for (int i = 1; i <= etapas; i++) {
            Etapa etapa = new Etapa(i, IDCaso, null, 0, new Byte("0"), 0);
            DBMS.setEtapa(accion, etapa, 1);
        }
    }
    
}
