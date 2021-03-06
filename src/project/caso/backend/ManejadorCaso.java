package project.caso.backend;

import codeandbugs01.BaseDatos;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import project.baseDatos.ManejadorBaseDatos;
import project.etapa.backend.Etapa;
import project.etapa.backend.ManejadorEtapa;
import project.usuario.Usuario;
import java.util.*;
import project.proyecto.backend.ManejadorProyecto;
import project.proyecto.backend.Proyecto;

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

    public List getTipoCaso() {
        String consulta = "SELECT * FROM TIPO_CASO";
        return DBMS.getTipoCaso(consulta, null, 0);
    }

    public TipoCaso getTipoCasoByCasoId(String idCaso) {
        String consulta = "SELECT TIPO_CASO.* FROM TIPO_CASO, CASO WHERE CASO.ID = ? AND CASO.TIPO = TIPO_CASO.NOMBRE;";
        TipoCaso Tipocaso = (TipoCaso) DBMS.getTipoCaso(consulta, idCaso, 1).get(0);
        return Tipocaso;
    }

    public List getCasoByStatusAndDpiAdmin(Usuario usr) {
        String consulta = "SELECT CASO.* FROM PROYECTO, CASO WHERE PROYECTO.DPI_ADMINISTRADOR = ? AND PROYECTO.ID = CASO.ID_PROYECTO AND PROYECTO.ESTADO = '1' "
                + "AND CASO.MOTIVO_CANCELACION IS NULL";
        return DBMS.getCaso(consulta, Integer.toString(usr.getDPI()), 1);
    }

    public List getCasoById(String id) {
        String consulta = "SELECT * FROM CASO WHERE ID = ?";
        return DBMS.getCaso(consulta, id, 1);
    }

    public List getCasoByProject(String idProject) {
        String consulta = "SELECT CASO.* FROM CASO, PROYECTO WHERE PROYECTO.ID = ? AND PROYECTO.ID = CASO.ID_PROYECTO";
        return DBMS.getCaso(consulta, idProject, 1);
    }

    public List getCasoByDpiDesar(Usuario usuario) {
        String consulta = "SELECT CASO.* FROM CASO, ETAPA WHERE ETAPA.DPI_DESARROLLADOR = ? AND ETAPA.ID_CASO = CASO.ID";
        return DBMS.getCaso(consulta, Integer.toString(usuario.getDPI()), 1);
    }
    
    public int getNumeroFinalizado(String idProyecto){
        String consulta = "SELECT COUNT(*) FROM CASO, PROYECTO WHERE PROYECTO.ID = ? AND CASO.ID_PROYECTO = PROYECTO.ID AND CASO.AVANCE = '100'";
        return DBMS.getCasosFinal(consulta, idProyecto);
    }
    
    public List getCasoByDate() throws Exception {
        Calendar fecha = new GregorianCalendar();
        Date fechaFin = null;
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int diaFinal = dia + 7;
        int mesFinal = mes + 1;
        String fechaFinal = (año + "-" + mesFinal + "-" + diaFinal);
        fechaFin = fechaFormat.parse(fechaFinal);
        String consulta = "SELECT * FROM CASO WHERE FECHA_LIMITE < '" + fechaFormat.format(fechaFin) + "'";
        return DBMS.getCaso(consulta, null, 0);
    }

    public List getCasoByTipoCaso(String tipoCaso) {
        String consulta = "SELECT * FROM CASO WHERE TIPO = ?";
        return DBMS.getCaso(consulta, tipoCaso, 2);
    }

    public HorasDinero getHorasDineroByProyecto(String idProyecto) {
        List<HorasDinero> listaHoras = new LinkedList<>();
        HorasDinero horasDinero = new HorasDinero(0, 0);
        String consulta = "SELECT ETAPA.HORAS_TRABAJADAS, ETAPA.COSTO FROM PROYECTO, ETAPA, CASO WHERE PROYECTO.ID = ? "
                + "AND ETAPA.ID_CASO = CASO.ID AND CASO.ID_PROYECTO = PROYECTO.ID";
        double horas = 0;
        double dinero = 0;
        if (DBMS.getHorasDinero(consulta, idProyecto, 1) != null) {
            listaHoras.addAll(DBMS.getHorasDinero(consulta, idProyecto, 1));
            for (HorasDinero hora : listaHoras) {
                dinero += hora.getHorasInvertidas() * hora.getDineroInvertido();
                horas += hora.getHorasInvertidas();
            }
            horasDinero = new HorasDinero(horas, dinero);
        }
        return horasDinero;
    }
    
    public HorasDinero getHorasDineroByDesarrollador(String dpiDesarrollador){
        List<HorasDinero> listaHoras = new LinkedList<>();
        HorasDinero horasDinero = new HorasDinero(0, 0);
        String consulta = "SELECT ETAPA.HORAS_TRABAJADAS, ETAPA.COSTO FROM PROYECTO, ETAPA, CASO WHERE "
                + "ETAPA.DPI_DESARROLLADOR = ? AND ETAPA.ID_CASO = CASO.ID AND CASO.ID_PROYECTO = PROYECTO.ID";
        double horas = 0;
        double dinero = 0;
        if (DBMS.getHorasDinero(consulta, dpiDesarrollador, 1) != null) {
            listaHoras.addAll(DBMS.getHorasDinero(consulta, dpiDesarrollador, 1));
            for (HorasDinero hora : listaHoras) {
                dinero += hora.getHorasInvertidas() * hora.getDineroInvertido();
                horas += hora.getHorasInvertidas();
            }
            horasDinero = new HorasDinero(horas, dinero);
        }
        return horasDinero;
    }
    
    public HorasDinero getHorasDineroByTipoCaso(String nombreCaso){
        List<HorasDinero> listaHoras = new LinkedList<>();
        HorasDinero horasDinero = new HorasDinero(0, 0);
        String consulta = "SELECT ETAPA.HORAS_TRABAJADAS, ETAPA.COSTO FROM PROYECTO, ETAPA, CASO WHERE CASO.TIPO = ? "
                + "AND ETAPA.ID_CASO = CASO.ID AND CASO.ID_PROYECTO = PROYECTO.ID;";
        double horas = 0;
        double dinero = 0;
        if (DBMS.getHorasDinero(consulta, nombreCaso, 1) != null) {
            listaHoras.addAll(DBMS.getHorasDinero(consulta, nombreCaso, 1));
            for (HorasDinero hora : listaHoras) {
                dinero += hora.getHorasInvertidas() * hora.getDineroInvertido();
                horas += hora.getHorasInvertidas();
            }
            horasDinero = new HorasDinero(horas, dinero);
        }
        return horasDinero;
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

    public void setCaso(String fechaIni, String fechaLim, String tipo, String IdProy) throws Exception {
        if (fechaIni.replaceAll("-", "").replaceAll(" ", "").isEmpty()) {
            throw new Exception("\"Fecha de Inicio\" vacia, intetelo de nuevo");
        } else if (fechaLim.replaceAll("-", "").replaceAll(" ", "").isEmpty()) {
            throw new Exception("\"Fecha Limite\" vacia, intetelo de nuevo");
        } else if (tipo.replaceAll(" ", "").isEmpty()) {
            throw new Exception("No hay \"Tipo de Caso\" disponibles, intetelo de nuevo");
        } else if (IdProy.replaceAll(" ", "").isEmpty()) {
            throw new Exception("No hay \"Proyectos\" disponibles, intentelo de nuevo");
        }
        String accion = "INSERT INTO CASO(FECHA_INICIO, FECHA_LIMITE, TIPO, ID_PROYECTO) VALUES (?, ?, ?, ?)";
        Date fechaInicio = fechaFormat.parse(fechaIni);
        Date fechaLimite = fechaFormat.parse(fechaLim);
        Caso caso = new Caso(0, fechaInicio, fechaLimite, null, 0, null, tipo, Integer.parseInt(IdProy));
        DBMS.setCaso(accion, caso);
    }

    public void updateCasoDate(Caso cas, String nuevaFecha) throws Exception {
        if (nuevaFecha.replaceAll("-", "").replaceAll(" ", "").isEmpty()) {
            throw new Exception("\"Fecha Limite\" vacia, intentelo de nuevo");
        }
        String update = "UPDATE CASO SET FECHA_LIMITE = ? WHERE ID = ?";
        Date fechaLimite = fechaFormat.parse(nuevaFecha);
        Caso caso = new Caso(cas.getID(), cas.getFechaInicio(), fechaLimite, null, 0, null, cas.getTipoCaso(), cas.getIdProyecto());
        DBMS.updateCaso(update, caso, 1);
    }

    public void cancelCaso(Caso cas, String motivoCancel) throws Exception {
        if (motivoCancel.isEmpty()) {
            throw new Exception("\"Motivo de Cancelacion\" vacio, intentelo de nuevo");
        } else if (motivoCancel.length() > 100) {
            throw new Exception("Se ha superado la cantidad maxima de caracteres validos, intentelo de nuevo");
        }
        Caso caso = new Caso(cas.getID(), cas.getFechaInicio(), cas.getFechaLimite(), null, 0, motivoCancel, cas.getTipoCaso(), cas.getIdProyecto());
        String update = "UPDATE CASO SET MOTIVO_CANCELACION = ? WHERE ID = ?";
        DBMS.updateCaso(update, caso, 2);
    }

    public void updateCasoDateAvance(Etapa etapa, String fecha) throws Exception {
        Caso caso = (Caso) getCasoById(Integer.toString(etapa.getIdCaso())).get(0);
        TipoCaso tc = (TipoCaso) getTipoCasoByNombre(caso.getTipoCaso()).get(0);
        String update = "";
        double numeroPasos = tc.getNumeroPasos();
        double numeroPaso = etapa.getNumeroPaso();
        double avance = 100 * (numeroPaso / numeroPasos);
        int opcion = 0;
        if (etapa.getNumeroPaso() == tc.getNumeroPasos()) {
            if (fecha.replaceAll("-", "").replaceAll(" ", "").isEmpty()) {
                update = "UPDATE CASO SET FECHA_ENTREGA = CURDATE(), AVANCE = ? WHERE ID = ?";
                opcion = 3;
            } else {
                update = "UPDATE CASO SET FECHA_ENTREGA = ?, AVANCE = ? WHERE ID = ?";
                opcion = 4;
                caso.setFechaEntrega(fechaFormat.parse(fecha));
            }
        } else {
            update = "UPDATE CASO SET AVANCE = ? WHERE ID = ?";
            opcion = 3;
        }
        caso.setAvance(avance);
        DBMS.updateCaso(update, caso, opcion);
    }

    public List getCantidadCasosAndStatus(int status) {
        ManejadorProyecto mp = new ManejadorProyecto(DB);
        List<Proyecto> listaProyectos = new LinkedList<>();
        List<CantidadCasos> listaCantidadCas = new LinkedList<>();
        if (status == 2) {
            if (mp.getProyectos() != null) {
                listaProyectos.addAll(mp.getProyectos());
                for (Proyecto pry : listaProyectos) {
                    int numeroCasos = 0;
                    if (getCasoByProject(Integer.toString(pry.getID())) != null) {
                        numeroCasos = getCasoByProject(Integer.toString(pry.getID())).size();
                    }
                    CantidadCasos cc = new CantidadCasos(pry.getID(), pry.getNombre(), numeroCasos, pry.getEstado());
                    listaCantidadCas.add(cc);
                }
            } else {
                listaCantidadCas = null;
            }
        } else {
            if (mp.getProyectoByStatus(status) != null) {
                listaProyectos.addAll(mp.getProyectoByStatus(status));
                for (Proyecto pry : listaProyectos) {
                    int numeroCasos = 0;
                    if (getCasoByProject(Integer.toString(pry.getID())) != null) {
                        numeroCasos = getCasoByProject(Integer.toString(pry.getID())).size();
                    }
                    CantidadCasos cc = new CantidadCasos(pry.getID(), pry.getNombre(), numeroCasos, pry.getEstado());
                    listaCantidadCas.add(cc);
                }
            } else {
                listaCantidadCas = null;
            }
        }
        return listaCantidadCas;
    }

}
