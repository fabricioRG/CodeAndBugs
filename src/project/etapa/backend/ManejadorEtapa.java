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
    
    public List getEtapaByDpiDesarrAproNull(Usuario usr){
        String consulta = "SELECT * FROM ETAPA WHERE DPI_DESARROLLADOR = ? AND APROBACION IS NULL AND COMENTARIO IS NULL";
        Etapa etapa = new Etapa(0, 0, null, 0, new Byte("0"), usr.getDPI(),0);
        return DBMS.getEtapa(consulta, etapa, 2);
    }
    
    public List getEtapaByDpiDesarrAproZero(Usuario usr){
        String consulta = "SELECT * FROM ETAPA WHERE DPI_DESARROLLADOR = ? AND APROBACION = '0' AND COMENTARIO IS NULL";
        Etapa etapa = new Etapa(0, 0, null, 0, new Byte("0"), usr.getDPI(),0);
        return DBMS.getEtapa(consulta, etapa, 2);
    }
    
    public List getEtapaComentarioNotNull(Usuario usuario){
        String consulta = "SELECT ETAPA.* FROM ETAPA, CASO, PROYECTO WHERE PROYECTO.DPI_ADMINISTRADOR = ? "
                + "AND PROYECTO.ID = CASO.ID_PROYECTO AND ETAPA.ID_CASO = CASO.ID AND COMENTARIO IS NOT NULL AND "
                + "APROBACION IS NULL AND PROYECTO.ESTADO = '1' AND CASO.MOTIVO_CANCELACION IS NULL;";
        Etapa etapa = new Etapa(0, 0, consulta, 0, new Byte("0"), usuario.getDPI(), 0);
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
    
    public void asignarDesarrollador(Etapa etapa, String dpiDesarr, String costo) throws Exception{
        String update = "UPDATE ETAPA SET DPI_DESARROLLADOR = ?, COSTO = ? WHERE NO_PASO = ? AND ID_CASO = ?";
        if(costo.contains("-")){
            throw new Exception("\"Costo\" no valido, ingrese numero positivos");
        } else if(costo.isEmpty()){
            throw new Exception("\"Costo\" vacio, intentelo de nuevo");
        }
        byte bite = new Byte("0");
        String bit = Byte.toString(etapa.getAprobacion());
        Etapa etapaFinal = new Etapa(etapa.getNumeroPaso(), etapa.getIdCaso(), null, 0, etapa.getAprobacion(), Integer.parseInt(dpiDesarr), Double.parseDouble(costo));
        if(etapa.getNumeroPaso() == 1){
            DBMS.updateEtapa(update, etapaFinal, 1);
        } else {
            int pasoAnterior = etapa.getNumeroPaso() -1;
            Etapa etp = (Etapa) getEtapaByCasoAndPaso(Integer.toString(pasoAnterior), Integer.toString(etapa.getIdCaso())).get(0);
            if(etp.getDpiDesarrollador() == 0){
                throw new Exception("No es posible asignar el Desarrollador a la Etapa Numero \"" + etapa.getNumeroPaso() + "\" e ID Caso \"" + etapa.getIdCaso() + "\"");
            } else if (etp.getAprobacion() == bite){
                throw new Exception("No es posible asignar el Desarrollador pues aun hay no se ha completado con la etapa anterior");
            } else {
                DBMS.updateEtapa(update, etapaFinal, 1);
            }
        }
    }
    
    public void entregarEtapa(Etapa etap, String comentario, String horasTrabajadas) throws Exception{
        if(comentario.isEmpty()){
            throw new Exception("\"Comentario\" vacio, intentelo de nuevo");
        } else if(comentario.length() > 100){
            throw new Exception("\"Numero permitido de caracteres superado (100) intentelo de nuevo");
        } else if(horasTrabajadas.isEmpty()){
            throw new Exception("\"Horas Trabajas\" vacio, intentelo de nuevo");
        } else if(horasTrabajadas.contains("-")){
            throw new Exception("Se ha ingresado numeros negativos, intentelo de nuevo");
        }
        double horasTraba = Double.parseDouble(horasTrabajadas) + etap.getHorasTrabajadas();
        String update = "UPDATE ETAPA SET COMENTARIO = ?, HORAS_TRABAJADAS = ?, APROBACION = null WHERE NO_PASO = ? AND ID_CASO = ?";
        etap.setComentario(comentario);
        etap.setHorasTrabajadas(horasTraba);
        DBMS.updateEtapa(update, etap, 2);
    }
    
    public void rechazarEtapa(Etapa etapa){
        String update = "UPDATE ETAPA SET COMENTARIO = null, APROBACION = '0' WHERE NO_PASO = ? AND ID_CASO = ?";
        DBMS.updateEtapa(update, etapa, 3);
    }
    
    public void aprobarEtapa(Etapa etapa){
        String update = "UPDATE ETAPA SET APROBACION = '1' WHERE NO_PASO = ? AND ID_CASO = ?";
        DBMS.updateEtapa(update, etapa, 3);
    }
    
}
