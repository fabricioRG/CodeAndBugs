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
        Etapa etapa = new Etapa(Integer.parseInt(NoPaso), Integer.parseInt(idCaso), null, 0, new Byte("0"), 0,0);
        return DBMS.getEtapa(consulta, etapa, 1);
    }
    
    public List getEtapaByDpiDesarrNull(Usuario usr){
        String consulta = "SELECT ETAPA.* FROM ETAPA, CASO, PROYECTO WHERE ETAPA.DPI_DESARROLLADOR IS NULL AND CASO.ID_PROYECTO = PROYECTO.ID AND "
                + "PROYECTO.DPI_ADMINISTRADOR = ? AND ETAPA.ID_CASO = CASO.ID AND MOTIVO_CANCELACION IS NULL AND PROYECTO.ESTADO = '1'";
        Etapa etapa = new Etapa(0, 0, null, 0, new Byte("0"), usr.getDPI(),0);
        return DBMS.getEtapa(consulta, etapa, 2);
    }
    
    public List getEtapaByDpiDesarr(Usuario usr){
        String consulta = "SELECT * FROM ETAPA WHERE DPI_DESARROLLADOR = ? AND COMENTARIO IS NULL";
        Etapa etapa = new Etapa(0, 0, null, 0, new Byte("0"), usr.getDPI(),0);
        return DBMS.getEtapa(consulta, etapa, 2);
    }
    
    public void setEtapaNoPasoIdCaso(int etapas, String idCaso){
        String accion = "INSERT INTO ETAPA(NO_PASO, ID_CASO) VALUES (?,?)";
        int IDCaso = Integer.parseInt(idCaso);
        for (int i = 1; i <= etapas; i++) {
            Etapa etapa = new Etapa(i, IDCaso, null, 0, new Byte("0"), 0,0);
            DBMS.setEtapa(accion, etapa, 1);
        }
    }
    
    public void updateEtapaDesarrollador(Etapa etapa, String dpiDesarr, String costo) throws Exception{
        String update = "UPDATE ETAPA SET DPI_DESARROLLADOR = ?, COSTO = ? WHERE NO_PASO = ? AND ID_CASO = ?";
        if(costo.contains("-")){
            throw new Exception("\"Costo\" no valido, ingrese numero positivos");
        } else if(costo.isEmpty()){
            throw new Exception("\"Costo\" vacio, intentelo de nuevo");
        }
        Etapa etapaFinal = new Etapa(etapa.getNumeroPaso(), etapa.getIdCaso(), null, 0, new Byte("0"), Integer.parseInt(dpiDesarr), Double.parseDouble(costo));
        if(etapa.getNumeroPaso() == 1){
            DBMS.updateEtapa(update, etapaFinal, 1);
        } else {
            int pasoAnterior = etapa.getNumeroPaso() -1;
            Etapa etp = (Etapa) getEtapaByCasoAndPaso(Integer.toString(pasoAnterior), Integer.toString(etapa.getIdCaso())).get(0);
            if(etp.getDpiDesarrollador() == 0){
                throw new Exception("No es posible asignar el Desarrollador a la Etapa Numero \"" + etapa.getNumeroPaso() + "\" e ID Caso \"" + etapa.getIdCaso() + "\"");
            } else {
                DBMS.updateEtapa(update, etapaFinal, 1);
            }
        }
        
    }
    
}
